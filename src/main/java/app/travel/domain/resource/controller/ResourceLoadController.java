package app.travel.domain.resource.controller;

import app.travel.common.annotation.ExcludedContextPath;
import app.travel.common.constant.other.ContentDispositionType;
import app.travel.domain.resource.service.IResourceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Resource_load-Api-Endpoints")
@ExcludedContextPath
@RequestMapping("/resource/load")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ResourceLoadController implements IResourceLoadController{

    IResourceService resourceService;

    @Override
    public byte[] getResource(String key, ContentDispositionType type, HttpServletResponse servletResponse) throws Exception {

        return resourceService.getResourceByKey(key, type, servletResponse);
    }

}
