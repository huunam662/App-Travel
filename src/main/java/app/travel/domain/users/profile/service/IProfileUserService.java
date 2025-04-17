package app.travel.domain.users.profile.service;

import app.travel.domain.resource.payload.request.ResourceUploadRequest;
import app.travel.domain.resource.payload.response.ResourceUploadResponse;
import app.travel.domain.users.profile.payload.request.EditProfileUserRequest;
import app.travel.model.profile_user.entity.ProfileUserEntity;
import app.travel.shared.payload.response.ResourceKeyResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.util.UUID;

public interface IProfileUserService {

    Boolean checkProfileUserByPhoneNumber(String phoneNumber);

    ProfileUserEntity getProfile();

    ProfileUserEntity createProfileUser(ProfileUserEntity profileUserEntity);

    ResourceKeyResponse<UUID> updateProfileUser(EditProfileUserRequest request);

    ResourceUploadResponse uploadProfileImage(ResourceUploadRequest request, HttpServletRequest servletRequest) throws Exception;

}
