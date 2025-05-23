package app.travel.shared.service.roles;

import app.travel.common.constant.other.Role;
import app.travel.model.roles.entity.RoleEntity;

import java.util.UUID;

public interface IRoleService {

    RoleEntity getRoleById(UUID id);

    RoleEntity getRoleByName(Role roleName);

    UUID getRoleIdByRoleName(Role roleName);

}
