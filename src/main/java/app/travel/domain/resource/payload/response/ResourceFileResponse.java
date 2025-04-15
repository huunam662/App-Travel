package app.travel.domain.resource.payload.response;

import app.travel.common.constant.ContentDispositionType;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResourceFileResponse {

    Resource resource;

    MediaType mediaType;

    Integer contentLength;

    ContentDispositionType contentDisposition;

}
