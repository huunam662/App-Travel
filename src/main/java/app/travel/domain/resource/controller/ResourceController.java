package app.travel.domain.resource.controller;

import app.travel.domain.resource.payload.request.UploadFileRequest;
import app.travel.domain.resource.payload.response.ResourceFileResponse;
import app.travel.domain.resource.payload.response.UploadFileResponse;
import app.travel.domain.resource.service.IResourceService;
import com.cloudinary.api.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Tag(name = "Resource-Api-Endpoints")
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
    public ResourceFileResponse getResource(String key) throws Exception {

        return resourceService.getResourceByKey(key);
    }
}
