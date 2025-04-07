package app.travel.model.tour_timeline_overview;

import app.travel.shared.entity.AuditEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@TableName("tour_timeline_overview")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TourTimelineOverviewEntity extends AuditEntity {

    @TableField("tour_timeline_id")
    UUID tourTimelineId;

    @TableField("overview_html")
    String overviewHtml;

    @TableField("image_url")
    String imageUrl;

    @TableField("image_name")
    String imageName;

}
