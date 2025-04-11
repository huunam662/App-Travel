package app.travel.domain.places.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChangeIsForeignRequest {

    @NotNull(message = "This field is required!")
    @NotBlank(message = "This field is required!")
    @NotEmpty(message = "This field is required!")
    UUID id;

    @NotNull(message = "This field is required!")
    Boolean isForeign;

}
