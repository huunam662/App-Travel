package app.travel.model.tokens.repository;

import app.travel.model.tokens.entity.TokenEntity;

import java.util.Optional;
import java.util.UUID;

public interface ITokenRepository {

    Optional<TokenEntity> findById(UUID id);

    Optional<TokenEntity> findByToken(String token);

    TokenEntity insert(TokenEntity tokenEntity);

    TokenEntity update(TokenEntity tokenEntity);

    void delete(TokenEntity tokenEntity);

    void deleteById(UUID id);

}
