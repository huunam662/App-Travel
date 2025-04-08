package app.travel.model.profile_user.repository;

import app.travel.model.profile_user.entity.ProfileUserEntity;

public interface IProfileUserRepository {

    Boolean existsByPhoneNumber(String phoneNumber);

    ProfileUserEntity insert(ProfileUserEntity profileUser);

}
