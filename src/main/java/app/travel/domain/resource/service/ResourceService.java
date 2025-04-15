package app.travel.domain.resource.service;

import app.travel.advice.exception.templates.ErrorHolderException;
import app.travel.common.constant.Error;
import app.travel.domain.resource.payload.response.UploadFileResponse;
import app.travel.shared.service.cloud.cloudinary.ICloudinaryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ResourceService implements IResourceService{

    ICloudinaryService cloudinaryService;

    @Override
    public UploadFileResponse uploadByCloudinary(MultipartFile file, String folderName) throws Exception {

        if(file == null || file.isEmpty())
            throw new ErrorHolderException(Error.REQUEST_RESOURCE_INVALID);

        Map uploadResponse = cloudinaryService.upload(file, folderName);

        return UploadFileResponse.builder()
                .type((String) uploadResponse.get("type"))
                .typeFile((String) uploadResponse.get("resource_type"))
                .formatFile((String) uploadResponse.get("format"))
                .urlFile((String) uploadResponse.get("secure_url"))
                .fileName(String.format("%s.%s", URLEncoder.encode((String) uploadResponse.get("public_id"), StandardCharsets.UTF_8), uploadResponse.get("format")))
                .build();
    }
}
