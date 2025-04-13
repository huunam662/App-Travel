package app.travel.domain.location.ward.controller;

import app.travel.converter.LocationWardConverter;
import app.travel.domain.location.ward.payload.request.LocationWardParams1Request;
import app.travel.domain.location.ward.payload.request.LocationWardParams2Request;
import app.travel.domain.location.ward.payload.response.LocationWardDistrictProvinceResponse;
import app.travel.domain.location.ward.service.ILocationWardService;
import app.travel.model.location.wards.entity.LocationWardEntity;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/location-ward")
@Tag(name = "Location_Ward-Api-Endpoints")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LocationWardController implements ILocationWardController {

    ILocationWardService locationWardService;

    @Override
    public List<LocationWardDistrictProvinceResponse> getLocationWard(String name, LocationWardParams2Request params) {

        List<LocationWardEntity> locationWards = locationWardService.getListByContainsName(name, params);

        return LocationWardConverter.INSTANCE.toListLocationWardDistrictProvinceResponse(locationWards);
    }

    @Override
    public List<LocationWardDistrictProvinceResponse> getLocationWardByParent(String districtId, String districtCode, LocationWardParams2Request params) {

        List<LocationWardEntity> locationWards = districtId != null
                ? locationWardService.getListWardByDistrictId(districtId, params)
                : locationWardService.getListWardByDistrictCode(districtCode, params);

        return LocationWardConverter.INSTANCE.toListLocationWardDistrictProvinceResponse(locationWards);
    }

    @Override
    public LocationWardDistrictProvinceResponse getLocationWardByName(String query, LocationWardParams1Request params) {

        LocationWardEntity locationWard = locationWardService.getByName(query, params);

        return LocationWardConverter.INSTANCE.toLocationWardDistrictProvinceResponse(locationWard);
    }

    @Override
    public LocationWardDistrictProvinceResponse getLocationWardByCode(String code, LocationWardParams1Request params) {

        LocationWardEntity locationWard = locationWardService.getByCodeName(code, params);

        return LocationWardConverter.INSTANCE.toLocationWardDistrictProvinceResponse(locationWard);
    }
}
