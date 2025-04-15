package app.travel.domain.auth.service;

import app.travel.advice.exception.templates.ErrorHolderException;
import app.travel.common.constant.Error;
import app.travel.common.constant.JwtTokenType;
import app.travel.common.constant.Role;
import app.travel.converter.AuthConverter;
import app.travel.converter.ProfileUserConverter;
import app.travel.domain.auth.payload.request.SignInRequest;
import app.travel.domain.auth.payload.request.SignUpRequest;
import app.travel.domain.auth.payload.response.SignInResponse;
import app.travel.domain.users.profile.service.IProfileUserService;
import app.travel.domain.users.user.service.IUserService;
import app.travel.helper.AuthHelper;
import app.travel.model.profile_user.entity.ProfileUserEntity;
import app.travel.model.roles.entity.RoleEntity;
import app.travel.model.tokens.entity.TokenEntity;
import app.travel.model.users.entity.UserEntity;
import app.travel.shared.identity.UserDetailsImpl;
import app.travel.shared.payload.response.JwtTokenResponse;
import app.travel.shared.payload.internal.CookieInternal;
import app.travel.shared.service.cookie.ICookieService;
import app.travel.shared.service.crypto.aes_gcm.ICryptoAesGcmService;
import app.travel.shared.service.jwt.IJwtService;
import app.travel.shared.service.mailer.IMailerService;
import app.travel.shared.service.roles.IRoleService;
import app.travel.shared.service.tokens.ITokenService;
import app.travel.value.AppCoreValue;
import app.travel.value.JwtValue;
import app.travel.value.PathValue;
import io.swagger.v3.core.util.Json;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Slf4j(topic = "AUTH-SERVICE")
@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthService implements IAuthService{

    AuthenticationManager authenticationManager;

    AppCoreValue appCoreValue;

    PathValue pathValue;

    JwtValue jwtValue;

    IJwtService jwtService;

    ITokenService tokenService;

    ICookieService cookieService;

    IUserService userService;

    IRoleService roleService;

    IProfileUserService profileUserService;

    IMailerService mailerService;

    ICryptoAesGcmService cryptoAesGcmService;

    AuthHelper authHelper;

    @Override
    @Transactional
    public SignInResponse signIn(SignInRequest request, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {

        Cookie cookie = cookieService.getCookieFrom(servletRequest, JwtTokenType.REFRESH.getNameSpecial(), Boolean.FALSE);

        if(cookie != null){

            TokenEntity tokenEntity = tokenService.getTokenById(UUID.fromString(cookie.getValue()), Boolean.FALSE);

            if(tokenEntity != null)
                tokenService.deleteToken(tokenEntity);
        }

        Authentication authentication = authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken.unauthenticated(request.getUsername(), request.getPassword())
        );

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        String accessToken = jwtService.generateToken(userDetails, JwtTokenType.ACCESS);

        String refreshToken = jwtService.generateToken(userDetails, JwtTokenType.REFRESH);

        UserEntity userEntity = userDetails.getUser();

        TokenEntity accessTokenEntity = tokenService.saveToken(accessToken, JwtTokenType.ACCESS, userEntity);

        TokenEntity refreshTokenEntity = tokenService.saveToken(refreshToken, JwtTokenType.REFRESH, userEntity);

        CookieInternal cookieInternal = CookieInternal.builder()
                .key(JwtTokenType.REFRESH.getNameSpecial())
                .value(refreshTokenEntity.getId().toString())
                .path(String.format("%s/", pathValue.getRefreshTokenPath()))
                .maxAge(jwtValue.getRefreshDurationTime().intValue())
                .build();

        cookieService.sendCookieInclude(cookieInternal, servletResponse);

        JwtTokenResponse tokensResponse = JwtTokenResponse.builder()
                .access(accessTokenEntity.getToken())
//                .refresh(refreshTokenEntity.getId())
                .build();

        return SignInResponse.builder()
                .token(tokensResponse)
                .build();
    }

    @Override
    public void signUp(SignUpRequest request) throws Exception {

        log.info("sign up for user: {}", request.getEmail());

        authHelper.checkSignUpRequestToDB(request);

        mailerService.sendEmailConfirmSignUp(request);
    }

    @Override
    @Transactional
    public SignInResponse refreshToken(HttpServletRequest request) {

        Cookie cookie = cookieService.getCookieFrom(request, JwtTokenType.REFRESH.getNameSpecial(), Boolean.TRUE);

        UUID refreshTokenId = UUID.fromString(cookie.getValue());

        TokenEntity tokenEntity = tokenService.getTokenById(refreshTokenId, Boolean.TRUE);

        String refreshToken = tokenEntity.getToken();

        Boolean tokenValid = jwtService.validateToken(refreshToken);

        if(!tokenValid){

            tokenService.deleteToken(tokenEntity);

            throw new ErrorHolderException(Error.INVALID_TOKEN);
        }

        UserEntity userEntity = userService.getUserById(tokenEntity.getUserId());

        RoleEntity roleEntity = roleService.getRoleById(userEntity.getRoleId());

        UserDetailsImpl userDetails = UserDetailsImpl.builder()
                .user(userEntity)
                .role(roleEntity)
                .build();

        String accessToken = jwtService.generateToken(userDetails, JwtTokenType.ACCESS);

        tokenEntity = tokenService.saveToken(accessToken, JwtTokenType.ACCESS, userEntity);

        JwtTokenResponse jwtTokenResponse = JwtTokenResponse.builder()
                .access(tokenEntity.getToken())
                .build();

        return SignInResponse.builder()
                .token(jwtTokenResponse)
                .build();
    }

    @Override
    @Transactional
    public void signUpConfirm(String drag) throws Exception {

        String signUpRequestJson = cryptoAesGcmService.decode(drag);

        SignUpRequest signUpRequest = Json.mapper().readValue(signUpRequestJson, SignUpRequest.class);

        authHelper.checkSignUpRequestToDB(signUpRequest);

        UserEntity userEntity = AuthConverter.INSTANCE.toUserEntityFromSignUpRequest(signUpRequest);
        userEntity.setIsEnabled(Boolean.TRUE);

        UUID roleId = roleService.getRoleIdByRoleName(Role.TOURIST);
        userEntity.setRoleId(roleId);

        userEntity = userService.saveUser(userEntity);

        ProfileUserEntity profileUserEntity = ProfileUserConverter.INSTANCE.toProfileUserEntityFromSignUpRequest(signUpRequest);
        profileUserEntity.setUserId(userEntity.getId());

        profileUserService.createProfileUser(profileUserEntity);

    }
}
