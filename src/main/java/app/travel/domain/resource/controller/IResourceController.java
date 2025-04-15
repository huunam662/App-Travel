package app.travel.domain.resource.controller;

import app.travel.common.annotation.DefaultMessage;
import app.travel.domain.resource.payload.request.UploadFileRequest;
import app.travel.domain.resource.payload.response.ResourceFileResponse;
import app.travel.domain.resource.payload.response.UploadFileResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

public interface IResourceController {

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @DefaultMessage(message = "Upload successful.")
    UploadFileResponse uploadResource(@ModelAttribute UploadFileRequest request, HttpServletRequest servletRequest) throws Exception;

    @GetMapping("/{key:.+}")
    ResourceFileResponse getResource(@PathVariable("key") String key) throws Exception;

}
