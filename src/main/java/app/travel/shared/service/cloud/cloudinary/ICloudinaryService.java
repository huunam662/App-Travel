package app.travel.shared.service.cloud.cloudinary;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface ICloudinaryService {

    Map upload(MultipartFile file, String folderName) throws Exception;

}
