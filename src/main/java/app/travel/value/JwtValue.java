package app.travel.value;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JwtValue {

    @Value("${app.jwt.issuer}")
    String issuer;

    @Value("${app.jwt.secret-key}")
    String secretKey;

    @Value("${app.jwt.access-duration-time}")
    Long accessDurationTime;

    @Value("${app.jwt.refresh-duration-time}")
    Long refreshDurationTime;
}
