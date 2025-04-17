package app.travel.value;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PathValue {


    @Value("${app.path.backend.refresh-token}")
    String refreshTokenPath;

    @Value("${app.path.frontend.signup-confirm}")
    String feSignupConfirmPath;

    @Value("${app.path.backend.resource-load}")
    String resourceLoadPath;
}
