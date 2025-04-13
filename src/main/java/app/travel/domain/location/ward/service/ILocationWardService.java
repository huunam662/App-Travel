package app.travel.domain.location.ward.service;

import app.travel.domain.location.ward.payload.request.LocationWardParams1Request;
import app.travel.domain.location.ward.payload.request.LocationWardParams2Request;
import app.travel.model.location.wards.entity.LocationWardEntity;

import java.util.List;

public interface ILocationWardService {

    LocationWardEntity getById(String id, LocationWardParams1Request params);

    LocationWardEntity getByCodeName(String codeName, LocationWardParams1Request params);

    LocationWardEntity getByName(String name, LocationWardParams1Request params);

    List<LocationWardEntity> getListWardLocation();

    List<LocationWardEntity> getListWardLocation(LocationWardParams1Request params);

    List<LocationWardEntity> getListByContainsName(String name, LocationWardParams2Request params);

    List<LocationWardEntity> getListWardLocation(LocationWardParams2Request params);

    List<LocationWardEntity> getListWardByDistrictId(String districtId, LocationWardParams2Request params);

    List<LocationWardEntity> getListWardByDistrictCode(String districtCode, LocationWardParams2Request params);

}
