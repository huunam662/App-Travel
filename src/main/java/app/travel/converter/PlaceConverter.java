package app.travel.converter;

import app.travel.domain.places.payload.request.ChangeIsForeignRequest;
import app.travel.domain.places.payload.request.EditPlaceRequest;
import app.travel.domain.places.payload.request.NewPlaceRequest;
import app.travel.domain.places.payload.response.PlaceResponse;
import app.travel.model.places.entity.PlaceEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(builder = @Builder(disableBuilder = true), unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PlaceConverter {

    PlaceConverter INSTANCE = Mappers.getMapper(PlaceConverter.class);

    PlaceResponse toPlaceResponse(PlaceEntity placeEntity);

    List<PlaceResponse> toPlaceResponseList(List<PlaceEntity> placeEntityList);

    PlaceEntity toPlaceEntity(NewPlaceRequest request);

    @Mapping(target = "id", ignore = true)
    void flowToPlaceEntity(@MappingTarget PlaceEntity place, EditPlaceRequest request);

}
