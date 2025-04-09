package app.travel.model.place_travels;

import app.travel.shared.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@TableName("place_travels")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlaceTravelEntity extends BaseEntity {

    @TableField("tour_id")
    UUID tourId;

    @TableField("place_id")
    UUID placeId;

}
