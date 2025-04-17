package app.travel.shared.payload.request;

import app.travel.common.constant.SortDirection;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springdoc.core.annotations.ParameterObject;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ParameterObject
public class FilterRequest {

    @Parameter(description = "Page at site", example = "1")
    @Min(value = 1, message = "Page number at site must be at least 1.")
    Integer page = 1;

    @Parameter(description = "Size elements in page at site.", example = "5")
    @Min(value = 5, message = "Size for page at site must be at least 5.")
    @Max(value = 100, message = "Size for page at site must be at most 100.")
    Integer pageSize = 5;

    @Parameter(description = "Search elements to load for page at site.", allowEmptyValue = true)
    String search = "";

    @Parameter(description = "Sort type for sort elements [ASC, DESC].")
    SortDirection sortType = SortDirection.DEFAULT;

}
