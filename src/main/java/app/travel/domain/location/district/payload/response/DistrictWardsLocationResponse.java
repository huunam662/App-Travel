package app.travel.domain.location.district.payload.response;

import app.travel.domain.location.ward.payload.response.WardLocationResponse;
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
public class DistrictWardsLocationResponse extends DistrictProvinceLocationResponse{

    List<WardLocationResponse> wards;

}
