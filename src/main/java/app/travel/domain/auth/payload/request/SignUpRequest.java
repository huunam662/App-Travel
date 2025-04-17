package app.travel.domain.auth.payload.request;

import app.travel.common.annotation.PasswordFormat;
import app.travel.common.annotation.PasswordMatch;
import app.travel.common.annotation.PhoneNumberFormat;
import app.travel.common.annotation.UsernameFormat;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@PasswordMatch(
        message = "Password doesn't matching, try confirm again.",
        passwordFieldName = "password",
        confirmPasswordFieldName = "confirmPassword"
)
public class SignUpRequest {

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

    @NotNull(message = "Username is required!")
    @NotBlank(message = "Username is required!")
    @Size(min = 12, message = "Username must at least 12 characters.")
    @UsernameFormat
    String username;

    @Email(message = "Email must be in the format: example@domain.com.")
    @NotBlank(message = "Email is required!")
    @NotNull(message = "Email is required!")
    String email;

    @PasswordFormat
    String password;

    @NotBlank(message = "Confirm password is required!")
    @NotNull(message = "Confirm password is required!")
    String confirmPassword;

}
