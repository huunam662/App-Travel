package app.travel.shared.service.cloud.cloudinary;

import app.travel.domain.resource.payload.request.UploadFileRequest;
import app.travel.shared.payload.internal.LoadResourceInternal;
import com.cloudinary.api.ApiResponse;
import org.springframework.core.io.Resource;

import java.util.Map;

public interface ICloudinaryService {

    Map upload(UploadFileRequest request) throws Exception;

    LoadResourceInternal loadResource(String fileName) throws Exception;

}
