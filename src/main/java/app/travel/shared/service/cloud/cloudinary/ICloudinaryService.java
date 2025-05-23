package app.travel.shared.service.cloud.cloudinary;

import app.travel.common.constant.other.CloudinaryUploadType;
import app.travel.domain.resource.payload.request.ResourceUploadRequest;
import app.travel.shared.payload.internal.ResourceLoadInternal;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Map;

public interface ICloudinaryService {

    Map upload(ResourceUploadRequest request, CloudinaryUploadType uploadType, HttpServletRequest servletRequest) throws Exception;

    ResourceLoadInternal loadResource(String fileName) throws Exception;

}
