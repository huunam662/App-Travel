package app.travel.domain.places.service;

import app.travel.domain.places.payload.request.PlaceFilterRequest;
import app.travel.domain.places.payload.response.PlaceResponse;
import app.travel.model.places.PlaceEntity;
import app.travel.shared.payload.response.FilterResponse;

import java.util.List;
import java.util.UUID;

public interface IPlaceService {

    PlaceEntity getPlaceById(UUID id);

    List<PlaceEntity> getAllPlaces();

    FilterResponse<PlaceResponse> filterPlaces(PlaceFilterRequest request);

}
