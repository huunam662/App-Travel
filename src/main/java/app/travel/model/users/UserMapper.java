package app.travel.model.users;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.Optional;
import java.util.UUID;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

    @Select("SELECT * FROM users u " +
            "WHERE u.id = #{id}"
    )
    Optional<UserEntity> findById(@Param("id") UUID id);


    @Select("SELECT * FROM users u " +
            "WHERE u.username = #{username}"
    )
    Optional<UserEntity> findByUsername(@Param("username") String username);


    @Select("SELECT * FROM users u " +
            "WHERE u.username = #{usernameOrEmail} " +
            "OR u.email = #{usernameOrEmail}"
    )
    Optional<UserEntity> findByUsernameOrEmail(@Param("usernameOrEmail") String usernameOrEmail);

    @Select("SELECT EXISTS(SELECT u.username FROM users u WHERE u.username = #{username})")
    Boolean isExistsByUsername(@Param("username") String username);

    @Select("SELECT EXISTS(SELECT u.email FROM users u WHERE u.email = #{email})")
    Boolean isExistsByEmail(String email);

    @Select("SELECT EXISTS(SELECT u.)")
    Boolean isExistsByPhoneNumber(@Param("phoneNumber") String phoneNumber);
}
