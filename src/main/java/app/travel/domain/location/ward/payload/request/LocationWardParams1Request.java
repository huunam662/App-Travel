package app.travel.domain.location.ward.payload.request;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.springdoc.core.annotations.ParameterObject;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ParameterObject
public class LocationWardParams1Request {

    @Parameter(description = "Include district.")
    Boolean includeDistrict = Boolean.FALSE;

    @Parameter(description = "Include province.")
    Boolean includeProvince = Boolean.FALSE;

}
