package app.travel.model.users.entity;

import app.travel.model.roles.entity.RoleEntity;
import app.travel.shared.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import java.util.UUID;

@TableName(value = "users", autoResultMap = true)
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity extends BaseEntity {

    @TableField("role_id")
    UUID roleId;

    @TableField("email")
    String email;

    @TableField("username")
    String username;

    @TableField("password")
    String password;

    @TableField("is_enabled")
    Boolean isEnabled;

    @TableField(exist = false)
    RoleEntity role;

}
