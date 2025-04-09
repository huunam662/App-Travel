package app.travel.model.feedbacks;

import app.travel.shared.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@TableName("feedbacks")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FeedbackEntity extends BaseEntity {

    @TableField("user_id")
    UUID userId;

    @TableField("tour_id")
    UUID tourId;

    @TableField("rating")
    Float rating;

    @TableField("content")
    String content;

}
