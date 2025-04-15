package app.travel.domain.resource.service;

import app.travel.domain.resource.payload.response.UploadFileResponse;
import org.springframework.web.multipart.MultipartFile;

public interface IResourceService {

    UploadFileResponse uploadByCloudinary(MultipartFile file, String folderName) throws Exception;

}
