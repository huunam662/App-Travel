package app.travel.model.location.districts.entity;

import app.travel.model.location.provinces.entity.LocationProvinceEntity;
import app.travel.model.location.wards.entity.LocationWardEntity;
import app.travel.shared.entity.LocationBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.List;

@TableName("location_districts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocationDistrictEntity extends LocationBaseEntity {

    @TableField("location_province_id")
    String locationProvinceId;

    @TableField(exist = false)
    LocationProvinceEntity province;

    @TableField(exist = false)
    List<LocationWardEntity> wards;

}
