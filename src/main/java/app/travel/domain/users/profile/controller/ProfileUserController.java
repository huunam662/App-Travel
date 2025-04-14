package app.travel.domain.users.profile.controller;


import app.travel.converter.ProfileUserConverter;
import app.travel.domain.users.profile.payload.response.ProfileUserHomeResponse;
import app.travel.domain.users.profile.service.IProfileUserService;
import app.travel.model.profile_user.entity.ProfileUserEntity;
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
    public ProfileUserHomeResponse loadProfile(HttpServletRequest request) {

        ProfileUserEntity profileUser = profileUserService.getProfile(request);

        return ProfileUserConverter.INSTANCE.toProfileUserHomeResponse(profileUser);
    }
}
