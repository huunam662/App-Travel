package app.travel.domain.resource.service;

import app.travel.domain.resource.payload.request.UploadFileRequest;
import app.travel.domain.resource.payload.response.ResourceFileResponse;
import app.travel.domain.resource.payload.response.UploadFileResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.io.Resource;

import java.io.IOException;

public interface IResourceService {

    UploadFileResponse uploadByCloudinary(UploadFileRequest request, HttpServletRequest servletRequest) throws Exception;

    ResourceFileResponse getResourceByKey(String key) throws Exception;

}
