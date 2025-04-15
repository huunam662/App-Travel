package app.travel.domain.users.user.service;

import app.travel.model.users.entity.UserEntity;
import app.travel.shared.identity.UserDetailsImpl;

import java.util.UUID;

public interface IUserService {

    UserEntity getUserByUsername(String username);

    UserEntity getUserByUsernameOrEmail(String usernameOrEmail);

    UserEntity getUserById(UUID id);

    Boolean checkUserByUsername(String username);

    Boolean checkUserByEmail(String email);

    UserEntity saveUser(UserEntity userEntity);

    UserDetailsImpl getUserAuthenticated();

}
