package app.travel.shared.service.tokens;

import app.travel.common.constant.other.JwtTokenType;
import app.travel.model.tokens.entity.TokenEntity;
import app.travel.model.users.entity.UserEntity;

import java.util.UUID;

public interface ITokenService {

    TokenEntity saveToken(String token, JwtTokenType tokenType, UserEntity user);

    void deleteTokenById(UUID tokenId);

    void deleteToken(TokenEntity token);

    TokenEntity getTokenById(UUID id, Boolean throwable);

    TokenEntity getTokenByToken(String token, Boolean throwable);

}
