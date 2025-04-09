package app.travel.model.location.districts;

import app.travel.shared.entity.LocationBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@TableName("districts_location")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DistrictLocationEntity extends LocationBaseEntity {

    @TableField("province_location_id")
    String provinceLocationId;

}
