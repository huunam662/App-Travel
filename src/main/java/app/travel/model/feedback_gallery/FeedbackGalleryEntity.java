package app.travel.model.feedback_gallery;

import app.travel.shared.entity.AuditEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@TableName("feedback_gallery")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FeedbackGalleryEntity extends AuditEntity {

    @TableField("feedback_id")
    UUID feedbackId;

    @TableField("image_url")
    String imageUrl;

}
