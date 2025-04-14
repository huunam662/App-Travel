package app.travel.domain.users.user.service;

import app.travel.advice.exception.templates.ErrorHolderException;
import app.travel.common.constant.Error;
import app.travel.model.roles.entity.RoleEntity;
import app.travel.model.users.entity.UserEntity;
import app.travel.model.users.repository.IUserRepository;
import app.travel.shared.identity.UserDetailsImpl;
import app.travel.shared.service.roles.IRoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Slf4j(topic = "USER-SERVICE")
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService implements IUserService, UserDetailsService {

    IUserRepository userRepository;

    IRoleService roleService;

    @Override
    public UserEntity getUserByUsername(String username) {

        log.info("get user by username {}", username);

        return userRepository.findByUsername(username).orElseThrow(
                () -> {

                    log.error("get user by username {} failed", username);

                    return new ErrorHolderException(Error.RESOURCE_NOT_FOUND);
                }
        );
    }

    @Override
    public UserEntity getUserByUsernameOrEmail(String usernameOrEmail) {

        log.info("get user by username or email {}", usernameOrEmail);

        return userRepository.findByUsernameOrEmail(usernameOrEmail).orElseThrow(
                () -> {

                    log.error("get user by username or email {} failed", usernameOrEmail);

                    return new ErrorHolderException(Error.RESOURCE_NOT_FOUND);
                }
        );
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("load user by username {}", username);

        UserEntity userEntity = userRepository.findByUsernameOrEmail(username)
                        .orElseThrow(
                                () -> {

                                    log.error("load user by username or email {} failed", username);

                                    return new UsernameNotFoundException(Error.BAD_CREDENTIALS.getMessage());
                                }
                        );

        RoleEntity roleEntity = roleService.getRoleById(userEntity.getRoleId());

        return UserDetailsImpl.builder()
                .user(userEntity)
                .role(roleEntity)
                .build();
    }

    @Override
    public UserEntity getUserById(UUID id) {

        log.info("get user by id {}", id);

        return userRepository.findById(id).orElseThrow(
                () -> {

                    log.error("get user by id {} failed", id);

                    return new ErrorHolderException(Error.RESOURCE_NOT_FOUND);
                }
        );
    }

    @Override
    public Boolean checkUserByUsername(String username) {

        log.info("check user by username: {}", username);

        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean checkUserByEmail(String email) {

        log.info("check user by email: {}", email);

        return userRepository.existsByEmail(email);
    }

    @Override
    @Transactional
    public UserEntity saveUser(UserEntity userEntity) {

        return userRepository.insert(userEntity);
    }
}
