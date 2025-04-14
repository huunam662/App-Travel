package app.travel.domain.users.profile.payload.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProfileUserResponse {

    UUID profileId;

    String firstName;

    String lastName;

    String phoneNumber;

    String identifyCode;

    String profileImage;

}
