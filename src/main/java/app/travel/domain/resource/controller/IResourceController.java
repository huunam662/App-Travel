package app.travel.domain.resource.controller;

import app.travel.common.annotation.DefaultMessage;
import app.travel.domain.resource.payload.response.UploadFileResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface IResourceController {

    @PostMapping(value = "/profile-user/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @DefaultMessage(message = "Upload successful.")
    UploadFileResponse uploadResource(@RequestPart("file") MultipartFile file) throws Exception;

}
