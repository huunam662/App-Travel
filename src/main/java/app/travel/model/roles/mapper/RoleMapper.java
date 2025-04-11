package app.travel.model.roles.mapper;

import app.travel.common.constant.Role;
import app.travel.model.roles.entity.RoleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import java.util.Optional;
import java.util.UUID;

@Mapper
public interface RoleMapper extends BaseMapper<RoleEntity> {

    @Select("SELECT * FROM roles r WHERE LOWER(r.role_name) = LOWER(#{roleName})")
    Optional<RoleEntity> selectByRoleName(@Param("roleName") Role role);

    @Select("SELECT r.id FROM roles r WHERE LOWER(r.role_name) = LOWER(#{roleName})")
    Optional<UUID> selectIdByRoleName(@Param("roleName") Role role);

}
