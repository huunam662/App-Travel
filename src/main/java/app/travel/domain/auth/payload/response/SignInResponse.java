package app.travel.domain.auth.payload.response;

import app.travel.shared.payload.response.JwtTokenResponse;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SignInResponse {

    JwtTokenResponse token;

}
