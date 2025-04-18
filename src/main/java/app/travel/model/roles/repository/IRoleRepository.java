package app.travel.model.roles.repository;

import app.travel.common.constant.other.Role;
import app.travel.model.roles.entity.RoleEntity;
import java.util.Optional;
import java.util.UUID;

public interface IRoleRepository {

    Optional<RoleEntity> findByRoleName(Role roleName);

    Optional<UUID> findIdByRoleName(Role roleName);

    Optional<RoleEntity> findById(UUID id);

}
