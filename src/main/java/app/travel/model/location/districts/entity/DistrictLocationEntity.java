package app.travel.model.location.districts.entity;

import app.travel.model.location.provinces.entity.ProvinceLocationEntity;
import app.travel.model.location.wards.entity.WardLocationEntity;
import app.travel.shared.entity.LocationBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.List;

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

    @TableField(exist = false)
    ProvinceLocationEntity province;

    @TableField(exist = false)
    List<WardLocationEntity> wards;

}
