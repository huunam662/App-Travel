package app.travel.model.founder_tours;

import app.travel.model.location.wards.entity.LocationWardEntity;
import app.travel.model.users.entity.UserEntity;
import app.travel.shared.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@TableName("founder_tours")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FounderTourEntity extends BaseEntity {

    @TableField("user_id")
    UUID userId;

    @TableField("ward_location_id")
    String wardLocationId;

    @TableField("company_name")
    String companyName;

    @TableField("email")
    String email;

    @TableField("phone_number")
    String phoneNumber;

    @TableField("enterprise_code")
    String enterpriseCode;

    @TableField("address_location")
    String addressLocation;

    @TableField(exist = false)
    UserEntity user;

    @TableField(exist = false)
    LocationWardEntity wardLocation;

}
