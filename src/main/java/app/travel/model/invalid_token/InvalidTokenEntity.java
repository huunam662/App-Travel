package app.travel.model.invalid_token;

import app.travel.shared.entity.AuditEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import java.util.UUID;

@TableName("invalid_token")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Schema(hidden = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InvalidTokenEntity extends AuditEntity {

    @TableField("user_id")
    UUID userId;

    @TableField("token")
    String token;

    @TableField("invalid_type")
    String invalidType;

}
