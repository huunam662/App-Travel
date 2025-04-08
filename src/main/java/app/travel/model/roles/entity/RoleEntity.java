package app.travel.model.roles.entity;

import app.travel.common.constant.Role;
import app.travel.shared.entity.AuditEntity;
import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@TableName("roles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleEntity extends AuditEntity {

    @TableField("role_name")
    @EnumValue
    Role roleName;

}
