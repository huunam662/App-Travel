package app.travel.shared.service.profile_user;

import app.travel.model.profile_user.entity.ProfileUserEntity;

public interface IProfileUserService {

    Boolean checkProfileUserByPhoneNumber(String phoneNumber);

    ProfileUserEntity saveProfileUser(ProfileUserEntity profileUserEntity);

}
