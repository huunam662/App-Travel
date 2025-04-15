package app.travel.domain.users.profile.service;

import app.travel.model.profile_user.entity.ProfileUserEntity;

public interface IProfileUserService {

    Boolean checkProfileUserByPhoneNumber(String phoneNumber);

    ProfileUserEntity createProfileUser(ProfileUserEntity profileUserEntity);

    ProfileUserEntity getProfile();

}
