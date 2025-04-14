package app.travel.domain.users.profile.controller;

import app.travel.common.annotation.DefaultMessage;
import app.travel.domain.users.profile.payload.response.ProfileUserHomeResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;

public interface IProfileUserController {

    @GetMapping("/home")
    @DefaultMessage(message = "Load profile successful.")
    ProfileUserHomeResponse loadProfile(HttpServletRequest request);

}
