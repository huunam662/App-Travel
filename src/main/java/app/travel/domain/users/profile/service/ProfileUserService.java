package app.travel.domain.users.profile.service;

import app.travel.advice.exception.templates.ErrorHolderException;
import app.travel.common.constant.Error;
import app.travel.common.constant.JwtTokenType;
import app.travel.model.profile_user.entity.ProfileUserEntity;
import app.travel.model.profile_user.repository.IProfileUserRepository;
import app.travel.model.tokens.entity.TokenEntity;
import app.travel.shared.service.cookie.ICookieService;
import app.travel.shared.service.tokens.ITokenService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Slf4j(topic = "PROFILE-USER-SERVICE")
@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProfileUserService implements IProfileUserService{

    IProfileUserRepository profileUserRepository;

    ITokenService tokenService;

    ICookieService cookieService;

    @Override
    public ProfileUserEntity getProfile(HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();

        Cookie cookie = cookieService.getCookieFrom(request, JwtTokenType.REFRESH.getNameSpecial(), true);

        UUID refreshTokenKey = UUID.fromString(cookie.getValue());

        TokenEntity refreshToken = tokenService.getTokenById(refreshTokenKey, true);

        ProfileUserEntity profileUser = profileUserRepository.findByUserId(refreshToken.getUserId())
                .orElseThrow(
                        () -> new ErrorHolderException(Error.RESOURCE_NOT_FOUND)
                );

        if(!profileUser.getUser().getIsEnabled())
            throw new ErrorHolderException(Error.ACCOUNT_DISABLED);

        return profileUser;
    }

    @Override
    public Boolean checkProfileUserByPhoneNumber(String phoneNumber) {

        log.info("check profile user by number phone: {}", phoneNumber);

        return profileUserRepository.existsByPhoneNumber(phoneNumber);
    }

    @Override
    @Transactional
    public ProfileUserEntity saveProfileUser(ProfileUserEntity profileUserEntity) {

        return profileUserRepository.insert(profileUserEntity);
    }
}
