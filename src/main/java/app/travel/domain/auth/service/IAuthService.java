package app.travel.domain.auth.service;

import app.travel.domain.auth.payload.request.SignInRequest;
import app.travel.domain.auth.payload.request.SignUpRequest;
import app.travel.domain.auth.payload.response.SignInResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface IAuthService {

    SignInResponse signIn(SignInRequest request, HttpServletRequest servletRequest, HttpServletResponse servletResponse);

    SignInResponse refreshToken(HttpServletRequest request);

    void signUp(SignUpRequest request) throws Exception;

    void signUpConfirm(String drag) throws Exception;

}
