package app.travel.shared.service.cloud.cloudinary;

import app.travel.common.constant.UploadType;
import app.travel.domain.resource.payload.request.ResourceUploadRequest;
import app.travel.shared.payload.internal.LoadResourceInternal;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Map;

public interface ICloudinaryService {

    Map upload(ResourceUploadRequest request, UploadType uploadType, HttpServletRequest servletRequest) throws Exception;

    LoadResourceInternal loadResource(String fileName) throws Exception;

}
