package app.travel.domain.location.province.payload.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocationProvinceResponse {

    String id;

    String name;

    String nameEn;

    String fullName;

    String fullNameEn;

    String codeName;

}
