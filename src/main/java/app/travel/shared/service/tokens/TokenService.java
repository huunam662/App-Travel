package app.travel.shared.service.tokens;

import app.travel.advice.exception.templates.ErrorHolderException;
import app.travel.common.constant.Error;
import app.travel.common.constant.JwtTokenType;
import app.travel.model.tokens.TokenEntity;
import app.travel.model.tokens.TokenMapper;
import app.travel.model.users.entity.UserEntity;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j(topic = "TOKEN-SERVICE")
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TokenService implements ITokenService{

    TokenMapper tokenMapper;

    @Override
    @Transactional
    public TokenEntity saveToken(String token, JwtTokenType tokenType, UserEntity user) {

        log.info("Saving token include: token {}, token type {}, user id {}", token, tokenType, user.getId());

        TokenEntity tokenEntity = TokenEntity.builder()
                .token(token)
                .tokenType(tokenType)
                .userId(user.getId())
                .build();

        tokenMapper.insert(tokenEntity);

        return tokenEntity;
    }

    @Override
    public TokenEntity getTokenById(UUID id) {

        log.info("get token by id {}", id);

        return Optional.ofNullable(tokenMapper.selectById(id)).orElseThrow(
                () -> {

                    log.error("get token by id {} failed", id);

                    return new ErrorHolderException(Error.RESOURCE_NOT_FOUND);
                }
        );
    }


    @Override
    @Transactional
    public void deleteTokenById(UUID tokenId) {

        TokenEntity tokenEntity = getTokenById(tokenId);

        deleteToken(tokenEntity);
    }

    @Override
    @Transactional
    public void deleteToken(TokenEntity token) {

        tokenMapper.deleteById(token);
    }

    @Override
    public TokenEntity getTokenByToken(String token, Boolean throwable) {

        TokenEntity tokenEntity = tokenMapper.selectByToken(token).orElse(null);

        if(tokenEntity == null && throwable)
            throw new ErrorHolderException(Error.RESOURCE_NOT_FOUND);

        return tokenEntity;
    }
}
