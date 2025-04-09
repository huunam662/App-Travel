package app.travel.model.comment_feedback;

import app.travel.shared.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@TableName("comment_feedback")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommentFeedbackEntity extends BaseEntity {

    @TableField("feedback_id")
    UUID feedbackId;

    @TableField("founder_tour_id")
    UUID founderTourId;

    @TableField("content")
    String content;

}
