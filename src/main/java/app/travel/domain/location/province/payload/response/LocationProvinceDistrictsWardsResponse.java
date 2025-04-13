package app.travel.domain.location.province.payload.response;

import app.travel.domain.location.district.payload.response.LocationDistrictWardsResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
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
public class LocationProvinceDistrictsWardsResponse extends LocationProvinceResponse{

    List<LocationDistrictWardsResponse> districts;

}
