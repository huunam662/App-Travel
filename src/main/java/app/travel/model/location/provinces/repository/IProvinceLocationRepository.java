package app.travel.model.location.provinces.repository;

import app.travel.model.location.provinces.entity.ProvinceLocationEntity;

import java.util.List;
import java.util.Optional;

public interface IProvinceLocationRepository {

    Optional<ProvinceLocationEntity> findById(String id);

    Optional<ProvinceLocationEntity> findById(String id, Boolean includeDistricts, Boolean includeWards);

    Optional<ProvinceLocationEntity> findByCodeName(String codeName);

    Optional<ProvinceLocationEntity> findByCodeName(String codeName, Boolean includeDistricts, Boolean includeWards);

    List<ProvinceLocationEntity> findAll();

    List<ProvinceLocationEntity> findAll(Boolean includeDistricts, Boolean includeWards);

    List<ProvinceLocationEntity> findAll(Boolean includeDistricts, Boolean includeWards, String orderBy, String sortDirection, int limit);

    List<ProvinceLocationEntity> findAllByNameLike(String name, Boolean includeDistricts, Boolean includeWards, String orderBy, String sortDirection, int limit);

}
