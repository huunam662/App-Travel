package app.travel.shared.service.profile_user;

import app.travel.model.profile_user.ProfileUserEntity;
import app.travel.model.profile_user.ProfileUserMapper;
import app.travel.model.profile_user.ProfileUserRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Slf4j(topic = "PROFILE-USER-SERVICE")
@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProfileUserService implements IProfileUserService {

    ProfileUserMapper profileUserMapper;

    ProfileUserRepository profileUserRepository;

    @Override
    public Boolean checkProfileUserByPhoneNumber(String numberPhone) {

        log.info("check profile user by number phone: {}", numberPhone);

        return profileUserMapper.isExistsByPhoneNumber(numberPhone);
    }

    @Override
    @Transactional
    public ProfileUserEntity saveProfileUser(ProfileUserEntity profileUserEntity) {

        return profileUserRepository.save(profileUserEntity);
    }
}
