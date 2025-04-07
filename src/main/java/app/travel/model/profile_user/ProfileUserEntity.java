package app.travel.model.profile_user;

import app.travel.shared.entity.AuditEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@TableName("profile_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProfileUserEntity extends AuditEntity {

    @TableField("user_id")
    UUID userId;

    @TableField("first_name")
    String firstName;

    @TableField("last_name")
    String lastName;

    @TableField("phone_number")
    String phoneNumber;

    @TableField("identify_code")
    String identifyCode;

    @TableField("profile_image")
    String profileImage;

}
