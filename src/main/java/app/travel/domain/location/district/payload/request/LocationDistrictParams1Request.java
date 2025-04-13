package app.travel.domain.location.district.payload.request;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.springdoc.core.annotations.ParameterObject;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@ParameterObject
public class LocationDistrictParams1Request {

    @Parameter(description = "Include province.")
    Boolean includeProvince = Boolean.FALSE;

    @Parameter(description = "Include wards.")
    Boolean includeWards = Boolean.FALSE;

}
