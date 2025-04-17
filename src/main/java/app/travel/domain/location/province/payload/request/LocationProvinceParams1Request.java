package app.travel.domain.location.province.payload.request;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springdoc.core.annotations.ParameterObject;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ParameterObject
public class LocationProvinceParams1Request {

    @Parameter(description = "Include Districts.")
    Boolean includeDistricts = Boolean.FALSE;

    @Parameter(description = "Include Wards.")
    Boolean includeWards = Boolean.FALSE;

}
