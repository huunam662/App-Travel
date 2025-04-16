package app.travel.domain.resource.controller;

import app.travel.common.annotation.ExcludedContextPath;
import app.travel.common.constant.ContentDispositionType;
import app.travel.domain.resource.payload.request.UploadFileRequest;
import app.travel.domain.resource.payload.response.UploadFileResponse;
import app.travel.domain.resource.service.IResourceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Resource-Api-Endpoints")
@ExcludedContextPath
@RequestMapping("/resource")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ResourceController implements IResourceController {

    IResourceService resourceService;

    @Override
    public UploadFileResponse uploadResource(UploadFileRequest request, HttpServletRequest servletRequest) throws Exception {

        return resourceService.uploadByCloudinary(request, servletRequest);
    }

    @Override
    public byte[] getResource(String key, ContentDispositionType type, HttpServletResponse servletResponse) throws Exception {

        return resourceService.getResourceByKey(key, type, servletResponse);
    }
}
