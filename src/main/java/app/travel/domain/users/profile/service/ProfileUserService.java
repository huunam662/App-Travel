package app.travel.domain.users.profile.service;

import app.travel.advice.exception.templates.ErrorHolderException;
import app.travel.common.constant.other.Error;
import app.travel.common.constant.other.CloudinaryUploadType;
import app.travel.converter.ProfileUserConverter;
import app.travel.domain.resource.payload.request.ResourceUploadRequest;
import app.travel.domain.resource.payload.response.ResourceUploadResponse;
import app.travel.domain.resource.service.IResourceService;
import app.travel.domain.users.profile.payload.request.EditProfileUserRequest;
import app.travel.domain.users.user.service.IUserService;
import app.travel.model.profile_user.entity.ProfileUserEntity;
import app.travel.model.profile_user.repository.IProfileUserRepository;
import app.travel.model.users.entity.UserEntity;
import app.travel.shared.identity.UserDetailsImpl;
import app.travel.shared.payload.response.ResourceKeyResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Slf4j(topic = "PROFILE-USER-SERVICE")
@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProfileUserService implements IProfileUserService{

    IUserService userService;

    IProfileUserRepository profileUserRepository;

    IResourceService resourceService;

    @Override
    public ProfileUserEntity getProfile() {

        UserDetailsImpl userDetailsImpl = userService.getUserAuthenticated();

        UserEntity user = userDetailsImpl.getUser();

        if(!user.getIsEnabled())
            throw new ErrorHolderException(Error.ACCOUNT_DISABLED);

        return profileUserRepository.findByUserId(user.getId());
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

    @Override
    @Transactional
    public ResourceKeyResponse<UUID> updateProfileUser(EditProfileUserRequest request) {

        ProfileUserEntity profileUser = getProfile();

        ProfileUserConverter.INSTANCE.flowToProfileUserEntity(profileUser, request);

        if(profileUser.getId() == null){

            profileUser.setUserId(profileUser.getUser().getId());

            profileUser = profileUserRepository.insert(profileUser);
        }
        else profileUser = profileUserRepository.update(profileUser);

        return ResourceKeyResponse.<UUID>builder()
                .key(profileUser.getUserId())
                .build();
    }

    @Override
    @Transactional
    public ResourceUploadResponse uploadProfileImage(ResourceUploadRequest request, HttpServletRequest servletRequest) throws Exception {

        ProfileUserEntity profileUser = getProfile();

        ResourceUploadResponse resourceUploadResponse = resourceService.uploadByCloudinary(request, CloudinaryUploadType.PROFILE_USER, servletRequest);

        profileUser.setProfileImage(resourceUploadResponse.getFileUrl());

        if(profileUser.getId() == null){

            profileUser.setUserId(profileUser.getUser().getId());

            profileUserRepository.insert(profileUser);
        }
        else profileUserRepository.update(profileUser);

        return resourceUploadResponse;
    }
}
