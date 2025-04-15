package app.travel.config.cloud.cloudinary;

import app.travel.value.CloudinaryValue;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CloudinaryConfig {

    CloudinaryValue cloudinaryValue;

    @Bean
    public Cloudinary cloudinary() {

        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudinaryValue.getCloudName(),
                "api_key", cloudinaryValue.getApiKey(),
                "api_secret", cloudinaryValue.getApiSecret(),
                "secure", true
        ));
    }

    @Bean(name = "webClientForCloudinary")
    public WebClient webClient(){

        return WebClient.builder()
                .baseUrl("https://res.cloudinary.com")
                .build();
    }


}
