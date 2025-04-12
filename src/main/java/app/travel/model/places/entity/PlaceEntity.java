package app.travel.model.places.entity;

import app.travel.model.tours.TourEntity;
import app.travel.shared.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.List;

@TableName("places")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlaceEntity extends BaseEntity {

    @TableField("place_name")
    String placeName;

    @TableField("is_foreign")
    Boolean isForeign;

    @TableField(exist = false)
    List<TourEntity> tours;

    @TableField(exist = false)
    List<TourEntity> toursTravel;
}
