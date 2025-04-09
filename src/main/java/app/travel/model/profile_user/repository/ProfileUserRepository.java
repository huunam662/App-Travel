package app.travel.model.profile_user.repository;

import app.travel.model.profile_user.entity.ProfileUserEntity;
import app.travel.model.profile_user.mapper.ProfileUserMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProfileUserRepository implements IProfileUserRepository{

    ProfileUserMapper profileUserMapper;

    @Override
    public Boolean existsByPhoneNumber(String phoneNumber) {

        return profileUserMapper.isExistsByPhoneNumber(phoneNumber);
    }

    @Override
    @Transactional
    public ProfileUserEntity insert(ProfileUserEntity profileUser) {

        profileUserMapper.insert(profileUser);

        return profileUser;
    }
}
