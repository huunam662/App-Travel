package app.travel.domain.places.payload.request;

import app.travel.common.constant.sort_by.PlaceSortBy;
import app.travel.shared.payload.request.FilterRequest;
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
public class PlaceFilterRequest extends FilterRequest {

    @Parameter(description = "Sort by field of object.")
    PlaceSortBy sortBy;

}
