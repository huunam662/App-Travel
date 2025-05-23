package app.travel.domain.users.profile.controller;


import app.travel.converter.ProfileUserConverter;
import app.travel.domain.resource.payload.request.ResourceUploadRequest;
import app.travel.domain.resource.payload.response.ResourceUploadResponse;
import app.travel.domain.users.profile.payload.request.EditProfileUserRequest;
import app.travel.domain.users.profile.payload.response.ProfileUserHomeResponse;
import app.travel.domain.users.profile.payload.response.ProfileUserResponse;
import app.travel.domain.users.profile.service.IProfileUserService;
import app.travel.model.profile_user.entity.ProfileUserEntity;
import app.travel.shared.payload.response.ResourceKeyResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-profile")
@Tag(name = "User_Profile-Api-Endpoints")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProfileUserController implements IProfileUserController{

    IProfileUserService profileUserService;

    @Override
    public ProfileUserHomeResponse loadProfileHome() {

        ProfileUserEntity profileUserHome = profileUserService.getProfile();

        return ProfileUserConverter.INSTANCE.toProfileUserHomeResponse(profileUserHome);
    }

    @Override
    public ProfileUserResponse loadProfile() {

        ProfileUserEntity profileUser = profileUserService.getProfile();

        return ProfileUserConverter.INSTANCE.toProfileUserResponse(profileUser);
    }

    @Override
    public ResourceKeyResponse<?> updateProfileUser(EditProfileUserRequest request) {

        return profileUserService.updateProfileUser(request);
    }

    @Override
    public ResourceUploadResponse uploadProfileImage(ResourceUploadRequest request, HttpServletRequest servletRequest) throws Exception {

        return profileUserService.uploadProfileImage(request, servletRequest);
    }
}
