package app.travel.domain.location.province.service;

import app.travel.model.location.provinces.entity.ProvinceLocationEntity;

import java.util.List;

public interface IProvinceLocationService {

    ProvinceLocationEntity getById(String id, Boolean includeDistricts, Boolean includeWards);

    ProvinceLocationEntity getByCodeName(String codeName, Boolean includeDistricts, Boolean includeWards);

    List<ProvinceLocationEntity> getListProvinceLocation();

    List<ProvinceLocationEntity> getListProvinceLocation(Boolean includeDistricts, Boolean includeWards);

    List<ProvinceLocationEntity> getListByContainsName(String name, Boolean includeDistricts, Boolean includeWards, String orderBy, String sortDirection, int limit);

    List<ProvinceLocationEntity> getListProvinceLocations(Boolean includeDistricts, Boolean includeWards, String orderBy, String sortDirection, int limit);

}
