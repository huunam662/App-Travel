package app.travel.shared.service.cloud.cloudinary;

import app.travel.advice.exception.templates.ErrorHolderException;
import app.travel.common.constant.CloudType;
import app.travel.common.constant.Error;
import app.travel.common.constant.UploadType;
import app.travel.domain.resource.payload.request.ResourceUploadRequest;
import app.travel.shared.payload.internal.LoadResourceInternal;
import app.travel.shared.payload.internal.ResourceFileInternal;
import app.travel.shared.service.crypto.aes_gcm.ICryptoAesGcmService;
import app.travel.utils.HttpUtils;
import com.cloudinary.Cloudinary;
import com.cloudinary.api.ApiResponse;
import com.cloudinary.utils.ObjectUtils;
import io.swagger.v3.core.util.Json;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Map;

@Slf4j(topic = "CLOUDINARY-SERVICE")
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CloudinaryService implements ICloudinaryService{

    Cloudinary cloudinary;

    ICryptoAesGcmService cryptoAesGcmService;

    RestTemplate restTemplate;

    @Override
    public Map upload(ResourceUploadRequest request, UploadType uploadType, HttpServletRequest servletRequest) throws Exception {

        MultipartFile file = request.getFile();

        ResourceFileInternal uploadFileInternal = ResourceFileInternal.builder()
                .folderName(uploadType.getFolder())
                .cloudType(CloudType.CLOUDINARY)
                .ipAddressClient(HttpUtils.getRequestIP(servletRequest))
                .build();

        String public_id = cryptoAesGcmService.encode(Json.pretty(uploadFileInternal));

        return cloudinary.uploader().upload(
                file.getBytes(),
                ObjectUtils.asMap(
//                "overwrite", true,
                        "resource_type", "auto",
                "public_id", public_id,
                "asset_folder", uploadType.getFolder()
        ));
    }

    @Override
    @SneakyThrows
    public LoadResourceInternal loadResource(String fileName) throws Exception {

        ApiResponse apiResponse = cloudinary.api().resource(fileName, ObjectUtils.asMap("quality_analysis", true));

        if(apiResponse == null) throw new ErrorHolderException(Error.RESOURCE_NOT_FOUND);

        String secureUrl = (String) apiResponse.get("secure_url");

        ResponseEntity<byte[]> responseFromMono = WebClient.create()
                .get()
                .uri(new URI(secureUrl))
                .retrieve()
                .toEntity(byte[].class)
                .doOnError(throwable -> log.error(throwable.getMessage()))
                .onErrorResume(throwable -> Mono.error(new ErrorHolderException(Error.RESOURCE_NOT_FOUND)))
                .block();

        if(responseFromMono == null || responseFromMono.getBody().length == 0)
            throw new ErrorHolderException(Error.RESOURCE_NOT_FOUND);

        byte[] resource = responseFromMono.getBody();
        MediaType contentType = responseFromMono.getHeaders().getContentType();
        long contentLength = responseFromMono.getHeaders().getContentLength();

//        URI uri = new URI(secureUrl);
//
//        ClientHttpRequest clientHttpRequest = restTemplate.getRequestFactory().createRequest(uri, HttpMethod.GET);
//
//        ClientHttpResponse clientHttpResponse = clientHttpRequest.execute();
//
//        byte[] resource = clientHttpResponse.getBody().readAllBytes();
//        MediaType contentType = clientHttpResponse.getHeaders().getContentType();
//        long contentLength = clientHttpResponse.getHeaders().getContentLength();

        return LoadResourceInternal.builder()
                .resource(resource)
                .resourceName(fileName)
                .contentLength(contentLength)
                .mediaType(contentType)
                .build();
    }
}
