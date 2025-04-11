package app.travel.domain.places.controller;

import app.travel.common.annotation.DefaultMessage;
import app.travel.domain.places.payload.request.ChangeIsForeignRequest;
import app.travel.domain.places.payload.request.EditPlaceRequest;
import app.travel.domain.places.payload.request.NewPlaceRequest;
import app.travel.domain.places.payload.request.PlaceFilterRequest;
import app.travel.domain.places.payload.response.PlaceResponse;
import app.travel.shared.payload.response.FilterResponse;
import app.travel.shared.payload.response.KeyResourceResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface IPlaceController {

    @GetMapping("/{id}")
    @DefaultMessage(message = "Load resource successful.")
    PlaceResponse getPlace(@PathVariable("id") UUID id);

    @GetMapping("/filter")
    @DefaultMessage(message = "Filter successful.")
    FilterResponse<PlaceResponse> filterPlaces(@Valid PlaceFilterRequest request);

    @PostMapping
    @DefaultMessage(message = "Save resource successful.")
    KeyResourceResponse<?> createPlace(@Valid @RequestBody NewPlaceRequest request);

    @PutMapping
    @DefaultMessage(message = "Save resource successful.")
    KeyResourceResponse<?> updatePlace(@Valid @RequestBody EditPlaceRequest request);

    @PatchMapping("/foreign")
    @DefaultMessage(message = "Save resource successful.")
    KeyResourceResponse<?> changePlaceIsForeign(@Valid @RequestBody ChangeIsForeignRequest request);

    @DeleteMapping("/{id}")
    @DefaultMessage(message = "Drop resource successful.")
    void deletePlace(@PathVariable("id") UUID id);



}
