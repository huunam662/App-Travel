package app.travel.shared.service.profile_user;

import app.travel.model.profile_user.entity.ProfileUserEntity;
import app.travel.model.profile_user.mapper.ProfileUserMapper;
import app.travel.model.profile_user.repository.IProfileUserRepository;
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

    IProfileUserRepository profileUserRepository;

    @Override
    public Boolean checkProfileUserByPhoneNumber(String phoneNumber) {

        log.info("check profile user by number phone: {}", phoneNumber);

        return profileUserRepository.existsByPhoneNumber(phoneNumber);
    }

    @Override
    @Transactional
    public ProfileUserEntity saveProfileUser(ProfileUserEntity profileUserEntity) {

        return profileUserRepository.insert(profileUserEntity);
    }
}
