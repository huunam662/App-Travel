package app.travel.domain.places.service;

import app.travel.domain.places.payload.request.ChangeIsForeignRequest;
import app.travel.domain.places.payload.request.EditPlaceRequest;
import app.travel.domain.places.payload.request.NewPlaceRequest;
import app.travel.domain.places.payload.request.PlaceFilterRequest;
import app.travel.domain.places.payload.response.PlaceResponse;
import app.travel.model.places.entity.PlaceEntity;
import app.travel.shared.payload.response.FilterResponse;
import app.travel.shared.payload.response.KeyResourceResponse;

import java.util.List;
import java.util.UUID;

public interface IPlaceService {

    PlaceEntity getPlaceById(UUID id);

    Boolean checkExistsByPlaceName(String placeName, Boolean throwable);

    List<PlaceEntity> getAllPlaces();

    FilterResponse<PlaceResponse> filterPlaces(PlaceFilterRequest request);

    KeyResourceResponse createPlace(NewPlaceRequest request);

    KeyResourceResponse updatePlace(EditPlaceRequest request);

    KeyResourceResponse changePlaceIsForeign(ChangeIsForeignRequest request);

    void deletePlaceById(UUID id);

    void deletePlace(PlaceEntity placeEntity);

}
