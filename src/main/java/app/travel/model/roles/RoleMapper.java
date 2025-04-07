package app.travel.model.roles;

import app.travel.common.constant.Role;
import org.apache.ibatis.annotations.*;

import java.util.Optional;
import java.util.UUID;

@Mapper
public interface RoleMapper {

    @Select("SELECT * FROM roles r " +
            "WHERE r.id = #{id}"
    )
    Optional<RoleEntity> findById(@Param("id") UUID id);

    @Select("SELECT * FROM roles r WHERE r.role_name = #{roleName}")
    Optional<RoleEntity> findByRoleName(@Param("roleName") Role role);

    @Select("SELECT r.id FROM roles r WHERE r.role_name = #{roleName}")
    Optional<UUID> findIdByRoleName(@Param("roleName") Role role);

}
