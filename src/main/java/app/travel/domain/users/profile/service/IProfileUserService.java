package app.travel.domain.users.profile.service;

import app.travel.model.profile_user.entity.ProfileUserEntity;
import jakarta.servlet.http.HttpServletRequest;

import java.util.UUID;

public interface IProfileUserService {

    Boolean checkProfileUserByPhoneNumber(String phoneNumber);

    ProfileUserEntity saveProfileUser(ProfileUserEntity profileUserEntity);

    ProfileUserEntity getProfile(HttpServletRequest request);

}
