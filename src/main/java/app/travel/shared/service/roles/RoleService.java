package app.travel.shared.service.roles;

import app.travel.advice.exception.templates.ErrorHolderException;
import app.travel.common.constant.Error;
import app.travel.common.constant.Role;
import app.travel.model.roles.entity.RoleEntity;
import app.travel.model.roles.mapper.RoleMapper;
import app.travel.model.roles.repository.IRoleRepository;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j(topic = "ROLE-SERVICE")
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleService implements IRoleService{

    IRoleRepository roleRepository;

    @Override
    public RoleEntity getRoleById(UUID id) {

        log.info("get role by id {}", id);

        return roleRepository.findById(id).orElseThrow(
                () -> {

                    log.error("get role by id {} failed", id);

                    return new ErrorHolderException(Error.RESOURCE_NOT_FOUND);
                }
        );
    }

    @Override
    public RoleEntity getRoleByName(Role roleName) {

        log.info("get role by name {}", roleName.getPrettyRoleName());

        return roleRepository.findByRoleName(roleName).orElseThrow(
                () -> {

                    log.error("get role by name {} failed", roleName.getPrettyRoleName());

                    return new ErrorHolderException(Error.RESOURCE_NOT_FOUND);
                }
        );
    }

    @Override
    public UUID getRoleIdByRoleName(Role roleName) {

        log.info("get role id by role name {}", roleName.getPrettyRoleName());

        return roleRepository.findIdByRoleName(roleName).orElseThrow(
                () -> {

                    log.error("get role id by role name {} failed", roleName.getPrettyRoleName());

                    return new ErrorHolderException(Error.RESOURCE_NOT_FOUND);
                }
        );
    }
}
