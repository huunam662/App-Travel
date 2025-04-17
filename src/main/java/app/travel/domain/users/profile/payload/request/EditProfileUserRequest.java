package app.travel.domain.users.profile.payload.request;

import app.travel.common.annotation.PhoneNumberFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EditProfileUserRequest {

    @NotBlank(message = "First name is required!")
    @NotNull(message = "First name is required!")
    String firstName;

    @NotBlank(message = "Last name is required!")
    @NotNull(message = "Last name is required!")
    String lastName;

    @NotBlank(message = "Phone number is required!")
    @NotNull(message = "Phone number is required!")
    @PhoneNumberFormat
    String phoneNumber;

    @NotBlank(message = "Identity code is required!")
    @NotNull(message = "Identity code is required!")
    String identifyCode;

}
