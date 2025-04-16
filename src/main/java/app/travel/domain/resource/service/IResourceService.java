package app.travel.domain.resource.service;

import app.travel.common.constant.ContentDispositionType;
import app.travel.domain.resource.payload.request.UploadFileRequest;
import app.travel.domain.resource.payload.response.UploadFileResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface IResourceService {

    UploadFileResponse uploadByCloudinary(UploadFileRequest request, HttpServletRequest servletRequest) throws Exception;

    byte[] getResourceByKey(String key, ContentDispositionType type, HttpServletResponse servletResponse) throws Exception;

}
