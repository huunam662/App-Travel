package app.travel.model.location.wards.repository;

import app.travel.model.location.wards.entity.LocationWardEntity;

import java.util.List;
import java.util.Optional;

public interface ILocationWardRepository {

    Optional<LocationWardEntity> findById(String id);

    Optional<LocationWardEntity> findById(String id, Boolean includeDistrict, Boolean includeProvince);

    Optional<LocationWardEntity> findByCodeName(String codeName);

    Optional<LocationWardEntity> findByCodeName(String codeName, Boolean includeDistrict, Boolean includeProvince);

    Optional<LocationWardEntity> findByName(String name, Boolean includeDistrict, Boolean includeProvince);

    List<LocationWardEntity> findAll();

    List<LocationWardEntity> findAll(Boolean includeDistrict, Boolean includeProvince);

    List<LocationWardEntity> findAll(Boolean includeDistrict, Boolean includeProvince, String orderBy, String sortType, Integer limit);

    List<LocationWardEntity> findAllByNameLike(String name, Boolean includeDistrict, Boolean includeProvince, String orderBy, String sortType, Integer limit);

    List<LocationWardEntity> findAllByDistrictId(String id, Boolean includeDistrict, Boolean includeProvince, String orderBy, String sortType, Integer limit);

    List<LocationWardEntity> findAllByDistrictCode(String code, Boolean includeDistrict, Boolean includeProvince, String orderBy, String sortType, Integer limit);

}
