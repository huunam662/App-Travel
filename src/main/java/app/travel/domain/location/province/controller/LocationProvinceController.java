package app.travel.domain.location.province.controller;

import app.travel.converter.LocationProvinceConverter;
import app.travel.domain.location.province.payload.request.LocationProvinceParams1Request;
import app.travel.domain.location.province.payload.request.LocationProvinceParams2Request;
import app.travel.domain.location.province.payload.response.LocationProvinceDistrictsWardsResponse;
import app.travel.domain.location.province.service.ILocationProvinceService;
import app.travel.model.location.provinces.entity.LocationProvinceEntity;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/location-province")
@Tag(name = "Location_Province-Api-Endpoints")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LocationProvinceController implements ILocationProvinceController{

    ILocationProvinceService locationProvinceService;

    @Override
    public List<LocationProvinceDistrictsWardsResponse> getLocationProvinces(String name, LocationProvinceParams2Request params) {

        List<LocationProvinceEntity> locationProvinceList = name == null
                ? locationProvinceService.getListProvinceLocations(params)
                : locationProvinceService.getListByContainsName(name, params);

        return LocationProvinceConverter.INSTANCE.toListLocationProvinceDistrictsWardsResponse(locationProvinceList);
    }

    @Override
    public LocationProvinceDistrictsWardsResponse getLocationProvinceByCode(String code, LocationProvinceParams1Request params) {

        LocationProvinceEntity locationProvince = locationProvinceService.getByCodeName(code, params);

        return LocationProvinceConverter.INSTANCE.toLocationProvinceDistrictsWardsResponse(locationProvince);
    }

    @Override
    public LocationProvinceDistrictsWardsResponse getLocationProvinceByName(String query, LocationProvinceParams1Request params) {

        LocationProvinceEntity locationProvince = locationProvinceService.getByName(query, params);

        return LocationProvinceConverter.INSTANCE.toLocationProvinceDistrictsWardsResponse(locationProvince);
    }
}
