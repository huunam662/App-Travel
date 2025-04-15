package app.travel.domain.resource.payload.request;

import app.travel.common.constant.UploadType;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UploadFileRequest {

    @Schema(description = "File for upload.")
    @NotNull(message = "File for upload is required!")
    MultipartFile file;

    @Schema(description = "Upload type for file.")
    @NotNull(message = "Upload type for file is required!")
    UploadType uploadType = UploadType.DEFAULT;

    @Hidden
    HttpServletRequest servletRequest;

}
