package app.travel.domain.places.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NewPlaceRequest {

    @NotNull(message = "This field is required!")
    @NotBlank(message = "This field is required!")
    @NotEmpty(message = "This field is required!")
    String placeName;

    @NotNull(message = "This field is required!")
    Boolean isForeign;

}
