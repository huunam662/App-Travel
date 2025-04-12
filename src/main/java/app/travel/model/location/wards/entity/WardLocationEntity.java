package app.travel.model.location.wards.entity;

import app.travel.model.founder_tours.FounderTourEntity;
import app.travel.model.location.districts.entity.DistrictLocationEntity;
import app.travel.shared.entity.LocationBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.List;

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

    @TableField(exist = false)
    DistrictLocationEntity district;

    @TableField(exist = false)
    List<FounderTourEntity> foundersAddress;
}
