package app.travel.value;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CloudinaryValue {

    @Value("${cloudinary.cloud-name}")
    String cloudName;

    @Value("${cloudinary.api-key}")
    String apiKey;

    @Value("${cloudinary.api-secret}")
    String apiSecret;

}
