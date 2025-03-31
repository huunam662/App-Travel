package app.travel.domain.auth.controller;

import app.travel.common.annotation.DefaultMessage;
import app.travel.domain.auth.payload.request.SignInRequest;
import app.travel.domain.auth.payload.response.SignInResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface IAuthController {

    @PostMapping("/sign-in")
    @DefaultMessage(message = "Authentication successful.")
    @ResponseStatus(HttpStatus.OK)
    SignInResponse signIn(@Valid @RequestBody SignInRequest request, HttpServletResponse response);

    @GetMapping("/refresh-token")
    @DefaultMessage(message = "Refreshing successful.")
    SignInResponse refreshToken(HttpServletRequest request);

}
