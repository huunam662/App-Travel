package app.travel.helper;

import app.travel.domain.auth.payload.request.SignUpRequest;
import app.travel.domain.users.profile.service.IProfileUserService;
import app.travel.domain.users.user.service.IUserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.coyote.BadRequestException;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthHelper {

    IUserService userService;

    IProfileUserService profileUserService;

    public void checkSignUpRequestToDB(SignUpRequest request) throws Exception {

        Boolean isExistedUsername = userService.checkUserByUsername(request.getUsername());

        if(isExistedUsername)
            throw new BadRequestException("Username is already existed!");

        Boolean isExistedEmail = userService.checkUserByEmail(request.getEmail());

        if(isExistedEmail)
            throw new BadRequestException("Email is already existed!");

        Boolean isExistedNumberPhone = profileUserService.checkProfileUserByPhoneNumber(request.getPhoneNumber());

        if(isExistedNumberPhone)
            throw new BadRequestException("Phone number is already existed!");
    }

}
