package app.travel.domain.users.profile.controller;

import app.travel.common.annotation.DefaultMessage;
import app.travel.domain.resource.payload.request.ResourceUploadRequest;
import app.travel.domain.resource.payload.response.ResourceUploadResponse;
import app.travel.domain.users.profile.payload.request.EditProfileUserRequest;
import app.travel.domain.users.profile.payload.response.ProfileUserHomeResponse;
import app.travel.domain.users.profile.payload.response.ProfileUserResponse;
import app.travel.shared.payload.response.ResourceKeyResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;

public interface IProfileUserController {

    @GetMapping("/home")
    @DefaultMessage(message = "Load profile successful.")
    ProfileUserHomeResponse loadProfileHome();

    @GetMapping
    @DefaultMessage(message = "Load profile successful.")
    ProfileUserResponse loadProfile();

    @PatchMapping
    @DefaultMessage(message = "Update resource successful.")
    ResourceKeyResponse<?> updateProfileUser(EditProfileUserRequest request);

    @PostMapping(value = "/upload-image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @DefaultMessage(message = "Upload profile image successful.")
    ResourceUploadResponse uploadProfileImage(@ModelAttribute ResourceUploadRequest request, HttpServletRequest servletRequest) throws Exception;
}
