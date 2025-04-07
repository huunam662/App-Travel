package app.travel.shared.service.tokens;

import app.travel.common.constant.JwtTokenType;
import app.travel.model.tokens.TokenEntity;
import app.travel.model.users.UserEntity;

import java.util.UUID;

public interface ITokenService {

    TokenEntity insertTokenInclude(String token, JwtTokenType tokenType, UserEntity user);

    void deleteTokenById(UUID tokenId);

    void deleteToken(TokenEntity token);

    TokenEntity getTokenById(UUID id);

    TokenEntity getTokenByToken(String token, Boolean throwable);

}
