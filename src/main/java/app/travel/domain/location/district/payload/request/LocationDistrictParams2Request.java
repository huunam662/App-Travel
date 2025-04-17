package app.travel.domain.location.district.payload.request;

import app.travel.common.constant.SortDirection;
import app.travel.common.constant.sort_by.LocationSortBy;
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
public class LocationDistrictParams2Request extends LocationDistrictParams1Request{

    @Parameter(description = "Sort by field.")
    LocationSortBy sortBy = LocationSortBy.DEFAULT;

    @Parameter(description = "Sort type [ASC, DESC]")
    SortDirection sortType = SortDirection.DEFAULT;

    @Parameter(description = "Limit for object in list.")
    Integer limit = null;

}
