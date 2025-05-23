package app.travel.domain.location.district.service;

import app.travel.domain.location.district.payload.request.LocationDistrictParams1Request;
import app.travel.domain.location.district.payload.request.LocationDistrictParams2Request;
import app.travel.model.location.districts.entity.LocationDistrictEntity;

import java.util.List;

public interface ILocationDistrictService {

    LocationDistrictEntity getById(String id, LocationDistrictParams1Request params);

    LocationDistrictEntity getByCodeName(String codeName, LocationDistrictParams1Request params);

    LocationDistrictEntity getByName(String name, LocationDistrictParams1Request params);

    List<LocationDistrictEntity> getListDistrictLocation();

    List<LocationDistrictEntity> getListDistrictLocation(LocationDistrictParams2Request params);

    List<LocationDistrictEntity> getListByContainsName(String name, LocationDistrictParams2Request params);

    List<LocationDistrictEntity> getListDistrictLocation(LocationDistrictParams1Request params);

    List<LocationDistrictEntity> getListDistrictByProvinceId(String provinceId, LocationDistrictParams2Request params);

    List<LocationDistrictEntity> getListDistrictByProvinceCode(String provinceCode, LocationDistrictParams2Request params);

}
