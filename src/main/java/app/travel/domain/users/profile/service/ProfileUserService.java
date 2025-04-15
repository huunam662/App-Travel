package app.travel.domain.users.profile.service;

import app.travel.advice.exception.templates.ErrorHolderException;
import app.travel.common.constant.Error;
import app.travel.domain.users.user.service.IUserService;
import app.travel.model.profile_user.entity.ProfileUserEntity;
import app.travel.model.profile_user.repository.IProfileUserRepository;
import app.travel.model.users.entity.UserEntity;
import app.travel.shared.identity.UserDetailsImpl;
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
public class ProfileUserService implements IProfileUserService{

    IUserService userService;

    IProfileUserRepository profileUserRepository;

    @Override
    public ProfileUserEntity getProfile() {

        UserDetailsImpl userDetailsImpl = userService.getUserAuthenticated();

        UserEntity user = userDetailsImpl.getUser();

        if(!user.getIsEnabled())
            throw new ErrorHolderException(Error.ACCOUNT_DISABLED);

        return profileUserRepository.findByUserId(user.getId())
                .orElseThrow(
                        () -> new ErrorHolderException(Error.RESOURCE_NOT_FOUND)
                );
    }

    @Override
    public Boolean checkProfileUserByPhoneNumber(String phoneNumber) {

        log.info("check profile user by number phone: {}", phoneNumber);

        return profileUserRepository.existsByPhoneNumber(phoneNumber);
    }

    @Override
    @Transactional
    public ProfileUserEntity createProfileUser(ProfileUserEntity profileUserEntity) {

        return profileUserRepository.insert(profileUserEntity);
    }

    

}
