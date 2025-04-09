package app.travel.model.tokens.repository;


import app.travel.model.tokens.entity.TokenEntity;
import app.travel.model.tokens.mapper.TokenMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j(topic = "TOKEN-REPOSITORY")
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TokenRepository implements ITokenRepository{

    TokenMapper tokenMapper;

    @Override
    public Optional<TokenEntity> findById(UUID id) {

        return Optional.ofNullable(tokenMapper.selectById(id));
    }

    @Override
    public Optional<TokenEntity> findByToken(String token) {

        return tokenMapper.selectByToken(token);
    }

    @Override
    @Transactional
    public TokenEntity insert(TokenEntity tokenEntity) {

        tokenMapper.insert(tokenEntity);

        return tokenEntity;
    }

    @Override
    @Transactional
    public TokenEntity update(TokenEntity tokenEntity) {

        tokenMapper.updateById(tokenEntity);

        return tokenEntity;
    }

    @Override
    @Transactional
    public void delete(TokenEntity tokenEntity) {

        tokenMapper.deleteById(tokenEntity);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {

        tokenMapper.deleteById(id);
    }
}
