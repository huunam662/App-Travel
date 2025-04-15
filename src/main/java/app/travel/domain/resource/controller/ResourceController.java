package app.travel.domain.resource.controller;

import app.travel.common.constant.FolderUpload;
import app.travel.domain.resource.payload.response.UploadFileResponse;
import app.travel.domain.resource.service.IResourceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@Tag(name = "Resource-Api-Endpoints")
@RequestMapping("/resource")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ResourceController implements IResourceController {

    IResourceService resourceService;

    @Override
    public UploadFileResponse uploadResource(MultipartFile file) throws Exception {

        return resourceService.uploadByCloudinary(file, FolderUpload.PROFILE_USER.getFolder());
    }
}
