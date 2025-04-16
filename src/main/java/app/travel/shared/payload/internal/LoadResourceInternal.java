package app.travel.shared.payload.internal;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.springframework.http.MediaType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoadResourceInternal {

    byte[] resource;

    String resourceName;

    MediaType mediaType;

    Long contentLength;


}
