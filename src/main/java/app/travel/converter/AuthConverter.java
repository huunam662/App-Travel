package app.travel.converter;

import app.travel.domain.auth.payload.request.SignUpRequest;
import app.travel.model.users.entity.UserEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface AuthConverter {

    AuthConverter INSTANCE = Mappers.getMapper(AuthConverter.class);

    UserEntity toUserEntityFromSignUpRequest(SignUpRequest signUpRequest);

}
