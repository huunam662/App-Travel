package app.travel.shared.service.profile_user;

import app.travel.model.profile_user.ProfileUserEntity;
import app.travel.model.profile_user.ProfileUserMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j(topic = "PROFILE-USER-SERVICE")
@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProfileUserService implements IProfileUserService {

    ProfileUserMapper profileUserMapper;

    @Override
    public Boolean checkProfileUserByPhoneNumber(String numberPhone) {

        log.info("check profile user by number phone: {}", numberPhone);

        return profileUserMapper.isExistsByPhoneNumber(numberPhone);
    }

    @Override
    @Transactional
    public ProfileUserEntity insertProfileUser(ProfileUserEntity profileUserEntity) {

        profileUserMapper.insert(profileUserMapper);

        return profileUserEntity;
    }
}
