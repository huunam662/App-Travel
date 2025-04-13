package app.travel.model.location.wards.entity;

import app.travel.model.founder_tours.FounderTourEntity;
import app.travel.model.location.districts.entity.LocationDistrictEntity;
import app.travel.shared.entity.LocationBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.List;

@TableName("location_wards")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocationWardEntity extends LocationBaseEntity {

    @TableField("location_district_id")
    String locationDistrictId;

    @TableField(exist = false)
    LocationDistrictEntity district;

    @TableField(exist = false)
    List<FounderTourEntity> foundersAddress;
}
