package app.travel.shared.service.profile_user;

import app.travel.model.profile_user.ProfileUserEntity;

public interface IProfileUserService {

    Boolean checkProfileUserByPhoneNumber(String numberPhone);

    ProfileUserEntity saveProfileUser(ProfileUserEntity profileUserEntity);

}
