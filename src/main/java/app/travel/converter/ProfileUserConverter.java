package app.travel.converter;

import app.travel.domain.auth.payload.request.SignUpRequest;
import app.travel.model.profile_user.entity.ProfileUserEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface ProfileUserConverter {

    ProfileUserConverter INSTANCE = Mappers.getMapper(ProfileUserConverter.class);

    ProfileUserEntity toProfileUserEntityFromSignUpRequest(SignUpRequest signUpRequest);

}
