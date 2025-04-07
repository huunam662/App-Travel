package app.travel.model.tokens;

import app.travel.common.constant.JwtTokenType;
import app.travel.shared.entity.AuditEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import java.util.UUID;

@TableName("tokens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Schema(hidden = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TokenEntity extends AuditEntity {

    @TableField("user_id")
    UUID userId;

    @TableField("token")
    String token;

    @TableField("token_type")
    JwtTokenType tokenType;

}
