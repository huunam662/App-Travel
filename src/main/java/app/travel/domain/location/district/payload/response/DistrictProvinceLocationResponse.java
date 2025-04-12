package app.travel.domain.location.district.payload.response;

import app.travel.domain.location.province.payload.response.ProvinceLocationResponse;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DistrictProvinceLocationResponse extends DistrictLocationResponse{

    ProvinceLocationResponse province;

}
