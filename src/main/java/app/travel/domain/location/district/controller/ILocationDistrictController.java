package app.travel.domain.location.district.controller;

import app.travel.common.annotation.DefaultMessage;
import app.travel.domain.location.district.payload.request.LocationDistrictParams1Request;
import app.travel.domain.location.district.payload.request.LocationDistrictParams2Request;
import app.travel.domain.location.district.payload.response.LocationDistrictProvinceWardsResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

public interface ILocationDistrictController {

    @GetMapping
    @DefaultMessage(message = "Load location districts successful.")
    List<LocationDistrictProvinceWardsResponse> getLocationDistrict(
            @RequestParam(value = "name", required = false) String name,
            LocationDistrictParams2Request params
    );

    @GetMapping("/name")
    @DefaultMessage(message = "Load location district successful.")
    LocationDistrictProvinceWardsResponse getLocationDistrictByName(
            @RequestParam(value = "query", required = false) String query,
            LocationDistrictParams1Request params
    );

    @GetMapping("/{code}")
    @DefaultMessage(message = "Load location district successful.")
    LocationDistrictProvinceWardsResponse getLocationDistrictByCode(
            @PathVariable("code") String code,
            LocationDistrictParams1Request params
    );

}
