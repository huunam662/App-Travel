package app.travel.converter;

import app.travel.domain.auth.payload.request.SignUpRequest;
import app.travel.model.profile_user.ProfileUserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfileUserConverter {

    ProfileUserConverter INSTANCE = Mappers.getMapper(ProfileUserConverter.class);

    ProfileUserEntity toProfileUserEntityFromSignUpRequest(SignUpRequest signUpRequest);

}
