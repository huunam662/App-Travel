package app.travel.model.location.wards;

import app.travel.shared.entity.LocationBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@TableName("wards_location")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WardLocationEntity extends LocationBaseEntity {

    @TableField("district_location_id")
    String districtLocationId;

}
