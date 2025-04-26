package app.travel.domain.resource.service;

import app.travel.common.constant.other.ContentDispositionType;
import app.travel.common.constant.other.CloudinaryUploadType;
import app.travel.domain.resource.payload.request.ResourceUploadRequest;
import app.travel.domain.resource.payload.response.ResourceUploadResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface IResourceService {

    ResourceUploadResponse uploadByCloudinary(ResourceUploadRequest request, CloudinaryUploadType uploadType, HttpServletRequest servletRequest) throws Exception;

    byte[] getResourceByKey(String key, ContentDispositionType type, HttpServletResponse servletResponse) throws Exception;

}
