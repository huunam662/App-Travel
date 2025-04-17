package app.travel.converter;

import app.travel.domain.auth.payload.request.SignUpRequest;
import app.travel.domain.users.profile.payload.request.EditProfileUserRequest;
import app.travel.domain.users.profile.payload.response.ProfileUserHomeResponse;
import app.travel.domain.users.profile.payload.response.ProfileUserResponse;
import app.travel.model.profile_user.entity.ProfileUserEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true), unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProfileUserConverter {

    ProfileUserConverter INSTANCE = Mappers.getMapper(ProfileUserConverter.class);

    ProfileUserEntity toProfileUserEntity(SignUpRequest signUpRequest);

    @Mapping(target = "profileId", source = "id")
    ProfileUserHomeResponse toProfileUserHomeResponse(ProfileUserEntity profileUserEntity);

    @Mapping(target = "profileId", source = "id")
    ProfileUserResponse toProfileUserResponse(ProfileUserEntity profileUserEntity);

    void flowToProfileUserEntity(@MappingTarget ProfileUserEntity profileUserEntity, EditProfileUserRequest editProfileUserRequest);
}
