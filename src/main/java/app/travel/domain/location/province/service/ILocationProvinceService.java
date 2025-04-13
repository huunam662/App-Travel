package app.travel.domain.location.province.service;

import app.travel.domain.location.province.payload.request.LocationProvinceParams1Request;
import app.travel.domain.location.province.payload.request.LocationProvinceParams2Request;
import app.travel.model.location.provinces.entity.LocationProvinceEntity;

import java.util.List;

public interface ILocationProvinceService {

    LocationProvinceEntity getById(String id, LocationProvinceParams1Request params);

    LocationProvinceEntity getByCodeName(String codeName, LocationProvinceParams1Request params);

    LocationProvinceEntity getByName(String name, LocationProvinceParams1Request params);

    List<LocationProvinceEntity> getListProvinceLocation();

    List<LocationProvinceEntity> getListProvinceLocation(LocationProvinceParams1Request params);

    List<LocationProvinceEntity> getListByContainsName(String name, LocationProvinceParams2Request params);

    List<LocationProvinceEntity> getListProvinceLocations(LocationProvinceParams2Request params);

}
