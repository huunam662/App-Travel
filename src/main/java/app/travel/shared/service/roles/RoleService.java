package app.travel.shared.service.roles;

import app.travel.advice.exception.templates.ErrorHolderException;
import app.travel.common.constant.Error;
import app.travel.common.constant.Role;
import app.travel.model.roles.RoleEntity;
import app.travel.model.roles.RoleMapper;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j(topic = "ROLE-SERVICE")
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleService implements IRoleService{

    RoleMapper roleMapper;

    @Override
    public RoleEntity getRoleById(UUID id) {

        log.info("get role by id {}", id);

        return roleMapper.findById(id).orElseThrow(
                () -> {

                    log.error("get role by id {} failed", id);

                    return new ErrorHolderException(Error.RESOURCE_NOT_FOUND);
                }
        );
    }

    @Override
    public RoleEntity getRoleByName(Role roleName) {

        log.info("get role by name {}", roleName.getPrettyRoleName());

        return roleMapper.findByRoleName(roleName).orElseThrow(
                () -> {

                    log.error("get role by name {} failed", roleName.getPrettyRoleName());

                    return new ErrorHolderException(Error.RESOURCE_NOT_FOUND);
                }
        );
    }

    @Override
    public UUID getRoleIdByRoleName(Role roleName) {

        log.info("get role id by role name {}", roleName.getPrettyRoleName());

        return roleMapper.findIdByRoleName(roleName).orElseThrow(
                () -> {

                    log.error("get role id by role name {} failed", roleName.getPrettyRoleName());

                    return new ErrorHolderException(Error.RESOURCE_NOT_FOUND);
                }
        );
    }
}
