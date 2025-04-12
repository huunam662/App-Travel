package app.travel.model.location.provinces.entity;

import app.travel.model.location.districts.entity.DistrictLocationEntity;
import app.travel.shared.entity.LocationBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.List;

@TableName("provinces_location")
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProvinceLocationEntity extends LocationBaseEntity {

    @TableField(exist = false)
    List<DistrictLocationEntity> districts;

}
