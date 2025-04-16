package app.travel.domain.resource.controller;

import app.travel.common.annotation.DefaultMessage;
import app.travel.common.constant.ContentDispositionType;
import app.travel.domain.resource.payload.request.UploadFileRequest;
import app.travel.domain.resource.payload.response.UploadFileResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

public interface IResourceController {

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @DefaultMessage(message = "Upload successful.")
    UploadFileResponse uploadResource(
            @ModelAttribute UploadFileRequest request,
            HttpServletRequest servletRequest
    ) throws Exception;

    @GetMapping("/{key:.+}")
    byte[] getResource(
            @PathVariable("key") String key,
            @RequestParam(value = "type", required = false) ContentDispositionType type,
            HttpServletResponse servletResponse
    ) throws Exception;

}
