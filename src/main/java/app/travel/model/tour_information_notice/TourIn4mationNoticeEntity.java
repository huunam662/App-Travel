package app.travel.model.tour_information_notice;

import app.travel.shared.entity.AuditEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import java.util.UUID;

@TableName("tour_information_notice")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TourIn4mationNoticeEntity extends AuditEntity {

    @TableField("tour_id")
    UUID tourId;

    @TableField("notice_name")
    String noticeName;

    @TableField("information_html")
    String informationHtml;

}
