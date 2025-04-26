package app.travel.domain.resource.service;

import app.travel.advice.exception.templates.ErrorHolderException;
import app.travel.common.constant.other.ContentDispositionType;
import app.travel.common.constant.other.Error;
import app.travel.common.constant.other.CloudinaryUploadType;
import app.travel.domain.resource.payload.request.ResourceUploadRequest;
import app.travel.domain.resource.payload.response.ResourceUploadResponse;
import app.travel.shared.payload.internal.ResourceLoadInternal;
import app.travel.shared.service.cloud.cloudinary.ICloudinaryService;
import app.travel.value.AppCoreValue;
import app.travel.value.PathValue;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ResourceService implements IResourceService{

    ICloudinaryService cloudinaryService;

    AppCoreValue appCoreValue;

    PathValue pathValue;

    @Override
    public ResourceUploadResponse uploadByCloudinary(ResourceUploadRequest request, CloudinaryUploadType uploadType, HttpServletRequest servletRequest) throws Exception {

        MultipartFile file = request.getFile();

        if(file == null || file.isEmpty())
            throw new ErrorHolderException(Error.REQUEST_RESOURCE_INVALID);

        if(uploadType == null) uploadType = CloudinaryUploadType.DEFAULT;

        Map uploadResponse = cloudinaryService.upload(request, uploadType, servletRequest);

        String fileName = (String) uploadResponse.get("public_id");

        return ResourceUploadResponse.builder()
                .type((String) uploadResponse.get("type"))
                .typeFile((String) uploadResponse.get("resource_type"))
                .formatFile((String) uploadResponse.get("format"))
                .fileUrl(String.format("%s%s/%s", appCoreValue.getBackendDomain(), pathValue.getResourceLoadPath(), fileName))
                .fileName(fileName)
                .build();
    }

    @Override
    public byte[] getResourceByKey(String key, ContentDispositionType type, HttpServletResponse servletResponse) throws Exception {

        if(key == null || key.isEmpty())
            throw new ErrorHolderException(Error.ILLEGAL_ARGUMENT);

        ResourceLoadInternal loadResourceInternal = cloudinaryService.loadResource(key);

        if(loadResourceInternal.getResource() == null)
            throw new ErrorHolderException(Error.RESOURCE_NOT_FOUND);

        String resourceName = loadResourceInternal.getResourceName();

        int resourceNameLength = resourceName.length();

        int subResourceName = resourceNameLength > 32 ? resourceNameLength - 32 : resourceNameLength;

        servletResponse.setContentType(loadResourceInternal.getMediaType().toString());
        servletResponse.setContentLength(loadResourceInternal.getContentLength().intValue());

        if(type == null) type = ContentDispositionType.DEFAULT;

        servletResponse.setHeader(
                HttpHeaders.CONTENT_DISPOSITION,
                type.getContentDisposition() + "; filename=" + resourceName.substring(subResourceName)
        );

        return loadResourceInternal.getResource();
    }

}
