package app.travel.model.roles.entity;

import app.travel.common.constant.other.Role;
import app.travel.model.founder_tours.entity.FounderTourEntity;
import app.travel.model.profile_user.entity.ProfileUserEntity;
import app.travel.model.users.entity.UserEntity;
import app.travel.shared.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.List;

@TableName("roles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleEntity extends BaseEntity {

    @TableField("role_name")
    @EnumValue
    Role roleName;

    @TableField(exist = false)
    List<UserEntity> users;

    @TableField(exist = false)
    ProfileUserEntity profileUser;

    @TableField(exist = false)
    FounderTourEntity founderTour;
}
