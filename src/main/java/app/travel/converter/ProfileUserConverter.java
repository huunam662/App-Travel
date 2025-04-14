package app.travel.converter;

import app.travel.domain.auth.payload.request.SignUpRequest;
import app.travel.domain.users.profile.payload.response.ProfileUserHomeResponse;
import app.travel.domain.users.profile.payload.response.ProfileUserResponse;
import app.travel.model.profile_user.entity.ProfileUserEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface ProfileUserConverter {

    ProfileUserConverter INSTANCE = Mappers.getMapper(ProfileUserConverter.class);

    ProfileUserEntity toProfileUserEntityFromSignUpRequest(SignUpRequest signUpRequest);

    ProfileUserHomeResponse toProfileUserHomeResponse(ProfileUserEntity profileUserEntity);

    ProfileUserResponse toProfileUserResponse(ProfileUserEntity profileUserEntity);

}
