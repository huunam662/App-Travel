package app.travel.model.tour_gallery;

import app.travel.shared.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import java.util.UUID;

@TableName("tour_gallery")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TourGalleryEntity extends BaseEntity {

    @TableField("tour_id")
    UUID tourId;

    @TableField("image_url")
    String imageUrl;

}
