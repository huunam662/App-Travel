package app.travel.domain.location.province.payload.response;

import app.travel.domain.location.district.payload.response.DistrictLocationResponse;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProvinceDistrictsLocationResponse extends ProvinceLocationResponse {

    List<DistrictLocationResponse> districts;

}
