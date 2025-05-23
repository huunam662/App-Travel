package app.travel.shared.service.tokens;

import app.travel.advice.exception.templates.ErrorHolderException;
import app.travel.common.constant.other.Error;
import app.travel.common.constant.other.JwtTokenType;
import app.travel.model.tokens.entity.TokenEntity;
import app.travel.model.tokens.repository.ITokenRepository;
import app.travel.model.users.entity.UserEntity;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Service
@Slf4j(topic = "TOKEN-SERVICE")
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TokenService implements ITokenService{

    ITokenRepository tokenRepository;

    @Override
    @Transactional
    public TokenEntity saveToken(String token, JwtTokenType tokenType, UserEntity user) {

        log.info("Saving token include: token {}, token type {}, user id {}", token, tokenType, user.getId());

        TokenEntity tokenEntity = TokenEntity.builder()
                .token(token)
                .tokenType(tokenType)
                .userId(user.getId())
                .build();

        return tokenRepository.insert(tokenEntity);
    }

    @Override
    public TokenEntity getTokenById(UUID id, Boolean throwable) {

        log.info("get token by id {}", id);

        TokenEntity tokenEntity = tokenRepository.findById(id).orElse(null);

        if(tokenEntity == null && throwable)
            throw new ErrorHolderException(Error.RESOURCE_NOT_FOUND);

        return tokenEntity;
    }


    @Override
    @Transactional
    public void deleteTokenById(UUID tokenId) {

        TokenEntity tokenEntity = getTokenById(tokenId, Boolean.TRUE);

        deleteToken(tokenEntity);
    }

    @Override
    @Transactional
    public void deleteToken(TokenEntity token) {

        tokenRepository.delete(token);
    }

    @Override
    public TokenEntity getTokenByToken(String token, Boolean throwable) {

        TokenEntity tokenEntity = tokenRepository.findByToken(token).orElse(null);

        if(tokenEntity == null && throwable)
            throw new ErrorHolderException(Error.RESOURCE_NOT_FOUND);

        return tokenEntity;
    }
}
