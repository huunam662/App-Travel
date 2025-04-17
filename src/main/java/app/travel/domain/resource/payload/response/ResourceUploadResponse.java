package app.travel.domain.resource.payload.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResourceUploadResponse {

    String type;

    String typeFile;

    String formatFile;

    String fileName;

    String fileUrl;


}
