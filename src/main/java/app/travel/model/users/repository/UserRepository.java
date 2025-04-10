package app.travel.model.users.repository;

import app.travel.model.users.entity.UserEntity;
import app.travel.model.users.mapper.UserMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserRepository implements IUserRepository{

    UserMapper userMapper;

    @Override
    @Transactional
    public UserEntity insert(UserEntity user) {

        userMapper.insert(user);

        return user;
    }

    @Override
    @Transactional
    public UserEntity update(UserEntity user) {

        userMapper.updateById(user);

        return user;
    }

    @Override
    @Transactional
    public void delete(UserEntity user) {

        userMapper.deleteById(user);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {

        userMapper.deleteById(id);
    }

    @Override
    public Optional<UserEntity> findByUsername(String username) {

        return userMapper.selectByUsername(username);
    }

    @Override
    public Optional<UserEntity> findByUsernameOrEmail(String usernameOrEmail) {

        return userMapper.selectByUsernameOrEmail(usernameOrEmail);
    }

    @Override
    public Boolean existsByUsername(String username) {

        return userMapper.isExistsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {

        return userMapper.isExistsByEmail(email);
    }

    @Override
    public Optional<UserEntity> findById(UUID id) {

        return Optional.ofNullable(userMapper.selectById(id));
    }
}
