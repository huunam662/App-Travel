package app.travel.converter;

import app.travel.domain.places.payload.request.EditPlaceRequest;
import app.travel.domain.places.payload.request.NewPlaceRequest;
import app.travel.domain.places.payload.response.PlaceResponse;
import app.travel.model.places.entity.PlaceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface PlaceConverter {

    PlaceConverter INSTANCE = Mappers.getMapper(PlaceConverter.class);

    PlaceResponse toPlaceResponse(PlaceEntity placeEntity);

    List<PlaceResponse> toPlaceResponseList(List<PlaceEntity> placeEntityList);

    PlaceEntity toPlaceEntity(NewPlaceRequest request);

    @Mapping(target = "id", ignore = true)
    PlaceEntity toPlaceEntity(EditPlaceRequest request);

}
