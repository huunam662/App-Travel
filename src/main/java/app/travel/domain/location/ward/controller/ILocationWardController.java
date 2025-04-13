package app.travel.domain.location.ward.controller;

import app.travel.common.annotation.DefaultMessage;
import app.travel.domain.location.ward.payload.request.LocationWardParams1Request;
import app.travel.domain.location.ward.payload.request.LocationWardParams2Request;
import app.travel.domain.location.ward.payload.response.LocationWardDistrictProvinceResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ILocationWardController {

    @GetMapping
    @DefaultMessage(message = "Load location wards successful.")
    List<LocationWardDistrictProvinceResponse> getLocationWard(
            @RequestParam(value = "name", required = false) String name,
            LocationWardParams2Request params
    );

    @GetMapping("/parent")
    @DefaultMessage(message = "Load location wards successful.")
    List<LocationWardDistrictProvinceResponse> getLocationWardByParent(
            @RequestParam(value = "districtId", required = false) String districtId,
            @RequestParam(value = "districtCode", required = false) String districtCode,
            LocationWardParams2Request params
    );

    @GetMapping("/name")
    @DefaultMessage(message = "Load location ward successful.")
    LocationWardDistrictProvinceResponse getLocationWardByName(
            @RequestParam(value = "query", required = false) String query,
            LocationWardParams1Request params
    );

    @GetMapping("/{code}")
    @DefaultMessage(message = "Load location ward successful.")
    LocationWardDistrictProvinceResponse getLocationWardByCode(
            @PathVariable("code") String code,
            LocationWardParams1Request params
    );

}
