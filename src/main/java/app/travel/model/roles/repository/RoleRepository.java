package app.travel.model.roles.repository;

import app.travel.common.constant.Role;
import app.travel.model.roles.entity.RoleEntity;
import app.travel.model.roles.mapper.RoleMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleRepository implements IRoleRepository{

    RoleMapper roleMapper;

    @Override
    public Optional<RoleEntity> findByRoleName(Role roleName) {

        return roleMapper.selectByRoleName(roleName);
    }

    @Override
    public Optional<UUID> findIdByRoleName(Role roleName) {

        return roleMapper.selectIdByRoleName(roleName);
    }

    @Override
    public Optional<RoleEntity> findById(UUID id) {

        return Optional.ofNullable(roleMapper.selectById(id));
    }

}
