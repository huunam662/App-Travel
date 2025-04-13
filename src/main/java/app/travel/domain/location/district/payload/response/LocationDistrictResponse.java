package app.travel.domain.location.district.payload.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocationDistrictResponse {

    String id;

    String name;

    String nameEn;

    String fullName;

    String fullNameEn;

    String codeName;

    String locationProvinceId;
}
