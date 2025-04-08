package app.travel.model.users.mapper;

import app.travel.model.users.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import java.util.Optional;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {


    @Select("SELECT * FROM users u " +
            "WHERE u.username = #{username}"
    )
    Optional<UserEntity> selectByUsername(@Param("username") String username);

    @Select("SELECT * FROM users u " +
            "WHERE u.username = #{usernameOrEmail} " +
            "OR u.email = #{usernameOrEmail}"
    )
    Optional<UserEntity> selectByUsernameOrEmail(@Param("usernameOrEmail") String usernameOrEmail);

    @Select("SELECT EXISTS(SELECT u.username FROM users u WHERE u.username = #{username})")
    Boolean isExistsByUsername(@Param("username") String username);

    @Select("SELECT EXISTS(SELECT u.email FROM users u WHERE u.email = #{email})")
    Boolean isExistsByEmail(String email);

}
