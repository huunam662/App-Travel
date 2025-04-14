package app.travel.model.profile_user.repository;

import app.travel.model.profile_user.entity.ProfileUserEntity;

import java.util.Optional;
import java.util.UUID;

public interface IProfileUserRepository {

    Boolean existsByPhoneNumber(String phoneNumber);

    ProfileUserEntity insert(ProfileUserEntity profileUser);

    Optional<ProfileUserEntity> findByUserId(UUID userId);

}
