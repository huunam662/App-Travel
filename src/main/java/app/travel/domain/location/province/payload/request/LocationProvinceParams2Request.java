package app.travel.domain.location.province.payload.request;

import app.travel.common.constant.sort_by.LocationSortBy;
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
public class LocationProvinceParams2Request extends LocationProvinceParams1Request{

    @Parameter(description = "Sort by field.")
    LocationSortBy sortBy = LocationSortBy.DEFAULT;

    @Parameter(description = "Limit for object in list.")
    Integer limit = null;

}
