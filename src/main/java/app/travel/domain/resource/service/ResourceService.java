package app.travel.domain.resource.service;

import app.travel.advice.exception.templates.ErrorHolderException;
import app.travel.common.constant.ContentDispositionType;
import app.travel.common.constant.Error;
import app.travel.domain.resource.payload.request.UploadFileRequest;
import app.travel.domain.resource.payload.response.ResourceFileResponse;
import app.travel.domain.resource.payload.response.UploadFileResponse;
import app.travel.shared.payload.internal.LoadResourceInternal;
import app.travel.shared.service.cloud.cloudinary.ICloudinaryService;
import app.travel.shared.service.crypto.aes_gcm.ICryptoAesGcmService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.URLConnection;
import java.util.Map;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ResourceService implements IResourceService{

    ICloudinaryService cloudinaryService;

    ICryptoAesGcmService cryptoAesGcmService;

    @Override
    public UploadFileResponse uploadByCloudinary(UploadFileRequest request, HttpServletRequest servletRequest) throws Exception {

        MultipartFile file = request.getFile();

        if(file == null || file.isEmpty())
            throw new ErrorHolderException(Error.REQUEST_RESOURCE_INVALID);

        request.setServletRequest(servletRequest);

        Map uploadResponse = cloudinaryService.upload(request);

        return UploadFileResponse.builder()
                .type((String) uploadResponse.get("type"))
                .typeFile((String) uploadResponse.get("resource_type"))
                .formatFile((String) uploadResponse.get("format"))
                .fileUrl((String) uploadResponse.get("secure_url"))
                .fileName(String.format("%s.%s", uploadResponse.get("public_id"), uploadResponse.get("format")))
                .build();
    }

    @Override
    public ResourceFileResponse getResourceByKey(String key) throws Exception {

        if(key == null || key.isEmpty())
            throw new ErrorHolderException(Error.ILLEGAL_ARGUMENT);

        LoadResourceInternal loadResourceInternal = cloudinaryService.loadResource(key);

        if(loadResourceInternal.getResource() == null) throw new ErrorHolderException(Error.RESOURCE_NOT_FOUND);

        Resource resource = loadResourceInternal.getResource();
        String resourceType = loadResourceInternal.getResourceType();
        String resourceFormat = loadResourceInternal.getResourceFormat();

        return ResourceFileResponse.builder()
                .resource(resource)
                .mediaType(MediaType.valueOf(String.format("%s/%s", resourceType, resourceFormat)))
                .contentLength(resource.getContentAsByteArray().length)
                .contentDisposition(ContentDispositionType.INLINE)
                .build();

    }

}
