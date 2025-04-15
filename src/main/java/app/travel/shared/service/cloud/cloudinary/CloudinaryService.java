package app.travel.shared.service.cloud.cloudinary;

import app.travel.common.constant.CloudType;
import app.travel.domain.resource.payload.request.UploadFileRequest;
import app.travel.shared.payload.internal.LoadResourceInternal;
import app.travel.shared.payload.internal.ResourceFileInternal;
import app.travel.shared.service.crypto.aes_gcm.ICryptoAesGcmService;
import app.travel.utils.HttpUtils;
import app.travel.value.CloudinaryValue;
import com.cloudinary.Cloudinary;
import com.cloudinary.api.ApiResponse;
import com.cloudinary.utils.ObjectUtils;
import io.swagger.v3.core.util.Json;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Slf4j(topic = "CLOUDINARY-SERVICE")
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CloudinaryService implements ICloudinaryService{

    Cloudinary cloudinary;

    CloudinaryValue cloudinaryValue;

    ICryptoAesGcmService cryptoAesGcmService;

    @NonFinal
    @Autowired
    @Qualifier("webClientForCloudinary")
    WebClient webClient;

    @Override
    public Map upload(UploadFileRequest request) throws Exception {

        MultipartFile file = request.getFile();

        HttpServletRequest servletRequest = request.getServletRequest();

        ResourceFileInternal uploadFileInternal = ResourceFileInternal.builder()
                .folderName(request.getUploadType().getFolder())
                .cloudType(CloudType.CLOUDINARY)
                .ipAddressClient(HttpUtils.getRequestIP(servletRequest))
                .build();

        String public_id = cryptoAesGcmService.encode(Json.pretty(uploadFileInternal));

        return cloudinary.uploader().upload(
                file.getBytes(),
                ObjectUtils.asMap(
                "overwrite", true,
                "public_id", public_id,
                "asset_folder", request.getUploadType().getFolder()
        ));
    }

//    @Override
//    public Resource loadResource(String fileName) throws Exception {
//
//        ApiResponse apiResponse = cloudinary.api().resource(fileName, ObjectUtils.asMap("quality_analysis", true));
//
//        String fileUrl = (String) apiResponse.get("secure_url");
//
//        return new UrlResource(fileUrl);
//
//    }

    @Override
    public LoadResourceInternal loadResource(String fileName) throws Exception {

        ApiResponse apiResponse = cloudinary.api().resource(fileName, ObjectUtils.asMap("quality_analysis", true));

        Resource resource = new UrlResource((String) apiResponse.get("secure_url"));
        String formatResource = (String) apiResponse.get("format");
        String resourceType = (String) apiResponse.get("resource_type");

        return LoadResourceInternal.builder()
                .resource(resource)
                .resourceFormat(formatResource)
                .resourceType(resourceType)
                .build();
    }
}
