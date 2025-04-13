package app.travel.domain.location.ward.payload.response;

import app.travel.domain.location.district.payload.response.LocationDistrictProvinceResponse;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocationWardDistrictProvinceResponse extends LocationWardResponse {

    LocationDistrictProvinceResponse district;

}
