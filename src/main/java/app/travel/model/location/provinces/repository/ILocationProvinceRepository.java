package app.travel.model.location.provinces.repository;

import app.travel.model.location.provinces.entity.LocationProvinceEntity;
import app.travel.model.location.provinces.mapper.LocationProvinceMapper;

import java.util.List;
import java.util.Optional;

public interface ILocationProvinceRepository {

    Optional<LocationProvinceEntity> findById(String id);

    Optional<LocationProvinceEntity> findById(String id, Boolean includeDistricts, Boolean includeWards);

    Optional<LocationProvinceEntity> findByCodeName(String codeName);

    Optional<LocationProvinceEntity> findByCodeName(String codeName, Boolean includeDistricts, Boolean includeWards);

    Optional<LocationProvinceEntity> findByName(String name, Boolean includeDistricts, Boolean includeWards);

    List<LocationProvinceEntity> findAll();

    List<LocationProvinceEntity> findAll(Boolean includeDistricts, Boolean includeWards);

    List<LocationProvinceEntity> findAll(Boolean includeDistricts, Boolean includeWards, String orderBy, Integer limit);

    List<LocationProvinceEntity> findAllByNameLike(String name, Boolean includeDistricts, Boolean includeWards, String orderBy, Integer limit);

}
