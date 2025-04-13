package app.travel.domain.location.district.controller;

import app.travel.converter.LocationDistrictConverter;
import app.travel.domain.location.district.payload.request.LocationDistrictParams1Request;
import app.travel.domain.location.district.payload.request.LocationDistrictParams2Request;
import app.travel.domain.location.district.payload.response.LocationDistrictProvinceWardsResponse;
import app.travel.domain.location.district.service.ILocationDistrictService;
import app.travel.model.location.districts.entity.LocationDistrictEntity;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/location-district")
@Tag(name = "Location_District-Api-Endpoints")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LocationDistrictController implements ILocationDistrictController {

    ILocationDistrictService locationDistrictService;

    @Override
    public List<LocationDistrictProvinceWardsResponse> getLocationDistrict(String name, LocationDistrictParams2Request params) {

        List<LocationDistrictEntity> locationDistricts = locationDistrictService.getListByContainsName(name, params);

        return LocationDistrictConverter.INSTANCE.toListLocationDistrictProvinceWardsResponse(locationDistricts);
    }

    @Override
    public List<LocationDistrictProvinceWardsResponse> getLocationDistrictByParent(String provinceId, String provinceCode, LocationDistrictParams2Request params) {

        List<LocationDistrictEntity> locationDistricts = provinceId != null
                ? locationDistrictService.getListDistrictByProvinceId(provinceId, params)
                : locationDistrictService.getListDistrictByProvinceCode(provinceCode, params);

        return LocationDistrictConverter.INSTANCE.toListLocationDistrictProvinceWardsResponse(locationDistricts);
    }

    @Override
    public LocationDistrictProvinceWardsResponse getLocationDistrictByName(String query, LocationDistrictParams1Request params) {

        LocationDistrictEntity locationDistrict = locationDistrictService.getByName(query, params);

        return LocationDistrictConverter.INSTANCE.toLocationDistrictProvinceWardsResponse(locationDistrict);
    }

    @Override
    public LocationDistrictProvinceWardsResponse getLocationDistrictByCode(String code, LocationDistrictParams1Request params) {

        LocationDistrictEntity locationDistrict = locationDistrictService.getByCodeName(code, params);

        return LocationDistrictConverter.INSTANCE.toLocationDistrictProvinceWardsResponse(locationDistrict);
    }
}
