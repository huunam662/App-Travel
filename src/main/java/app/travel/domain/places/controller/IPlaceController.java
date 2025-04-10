package app.travel.domain.places.controller;

import app.travel.common.annotation.DefaultMessage;
import app.travel.domain.places.payload.request.PlaceFilterRequest;
import app.travel.domain.places.payload.response.PlaceResponse;
import app.travel.shared.payload.response.FilterResponse;
import org.springframework.web.bind.annotation.GetMapping;

public interface IPlaceController {

    @GetMapping
    @DefaultMessage(message = "Filter successful.")
    FilterResponse<PlaceResponse> filterPlaces(PlaceFilterRequest request);

}
