package app.travel.model.tour_timeline;

import app.travel.shared.entity.AuditEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@TableName("tour_timeline")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TourTimelineEntity extends AuditEntity {

    @TableField("tour_id")
    UUID tourId;

    @TableField("tour_name")
    String tourName;

    @TableField("tour_day")
    Integer tourDay;

    @TableField("image_url")
    String imageUrl;

}
