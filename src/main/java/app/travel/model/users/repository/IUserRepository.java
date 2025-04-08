package app.travel.model.users.repository;

import app.travel.model.users.entity.UserEntity;

import java.util.Optional;
import java.util.UUID;

public interface IUserRepository {

    Optional<UserEntity> findByUsername(String username);

    Optional<UserEntity> findByUsernameOrEmail(String usernameOrEmail);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    UserEntity insert(UserEntity user);

    UserEntity update(UserEntity user);

    void delete(UserEntity user);

    void deleteById(UUID id);

    Optional<UserEntity> findById(UUID id);
}
