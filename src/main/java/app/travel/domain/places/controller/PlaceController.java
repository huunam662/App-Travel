package app.travel.domain.places.controller;

import app.travel.converter.PlaceConverter;
import app.travel.domain.places.payload.request.ChangeIsForeignRequest;
import app.travel.domain.places.payload.request.EditPlaceRequest;
import app.travel.domain.places.payload.request.NewPlaceRequest;
import app.travel.domain.places.payload.request.PlaceFilterRequest;
import app.travel.domain.places.payload.response.PlaceResponse;
import app.travel.domain.places.service.IPlaceService;
import app.travel.model.places.entity.PlaceEntity;
import app.travel.shared.payload.response.FilterResponse;
import app.travel.shared.payload.response.ResourceKeyResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;


@RestController
@Tag(name = "Place-Api-Endpoints")
@RequestMapping("/places")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PlaceController implements IPlaceController {

    IPlaceService placeService;

    @Override
    public FilterResponse<PlaceResponse> filterPlaces(PlaceFilterRequest params) {

        return placeService.filterPlaces(params);
    }

    @Override
    public ResourceKeyResponse<?> createPlace(NewPlaceRequest request) {

        return placeService.createPlace(request);
    }

    @Override
    public ResourceKeyResponse<?> updatePlace(EditPlaceRequest request) {

        return placeService.updatePlace(request);
    }

    @Override
    public ResourceKeyResponse<?> changePlaceIsForeign(ChangeIsForeignRequest request) {

        return placeService.changePlaceIsForeign(request);
    }

    @Override
    public PlaceResponse getPlace(UUID id) {

        PlaceEntity place = placeService.getPlaceById(id);

        return PlaceConverter.INSTANCE.toPlaceResponse(place);
    }

    @Override
    public void deletePlace(UUID id) {

        placeService.deletePlaceById(id);
    }
}
