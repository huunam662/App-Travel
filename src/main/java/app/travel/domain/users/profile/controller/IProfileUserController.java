package app.travel.domain.users.profile.controller;

import app.travel.common.annotation.DefaultMessage;
import app.travel.domain.users.profile.payload.response.ProfileUserHomeResponse;
import app.travel.domain.users.profile.payload.response.ProfileUserResponse;
import org.springframework.web.bind.annotation.GetMapping;

public interface IProfileUserController {

    @GetMapping("/home")
    @DefaultMessage(message = "Load profile successful.")
    ProfileUserHomeResponse loadProfileHome();

    @GetMapping
    @DefaultMessage(message = "Load profile successful.")
    ProfileUserResponse loadProfile();

}
