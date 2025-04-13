package app.travel.domain.location.province.controller;

import app.travel.common.annotation.DefaultMessage;
import app.travel.domain.location.province.payload.request.LocationProvinceParams1Request;
import app.travel.domain.location.province.payload.request.LocationProvinceParams2Request;
import app.travel.domain.location.province.payload.response.LocationProvinceDistrictsWardsResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ILocationProvinceController {

    @GetMapping
    @DefaultMessage(message = "Load location provinces successful.")
    List<LocationProvinceDistrictsWardsResponse> getLocationProvinces(
            @RequestParam(value = "name", required = false) String name,
            LocationProvinceParams2Request params
    );

    @GetMapping("/name")
    @DefaultMessage(message = "Load location province successful.")
    LocationProvinceDistrictsWardsResponse getLocationProvinceByName(
            @RequestParam(value = "query", required = false) String query,
            LocationProvinceParams1Request params
    );

    @GetMapping("/{code}")
    @DefaultMessage(message = "Load location province successful.")
    LocationProvinceDistrictsWardsResponse getLocationProvinceByCode(
            @PathVariable("code") String code,
            LocationProvinceParams1Request params
    );

}
