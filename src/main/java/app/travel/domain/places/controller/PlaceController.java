package app.travel.domain.places.controller;

import app.travel.domain.places.payload.request.PlaceFilterRequest;
import app.travel.domain.places.payload.response.PlaceResponse;
import app.travel.domain.places.service.IPlaceService;
import app.travel.shared.payload.response.FilterResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Tag(name = "Place-Api-Endpoints")
@RequestMapping("/places")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PlaceController implements IPlaceController {

    IPlaceService placeService;

    @Override
    public FilterResponse<PlaceResponse> filterPlaces(PlaceFilterRequest request) {

        return placeService.filterPlaces(request);
    }
}
