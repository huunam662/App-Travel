package app.travel.model.location.districts.repository;

import app.travel.model.location.districts.entity.LocationDistrictEntity;
import java.util.List;
import java.util.Optional;

public interface ILocationDistrictRepository {

    Optional<LocationDistrictEntity> findById(String id);

    Optional<LocationDistrictEntity> findById(String id, Boolean includeProvince, Boolean includeWards);

    Optional<LocationDistrictEntity> findByCodeName(String codeName);

    Optional<LocationDistrictEntity> findByCodeName(String codeName, Boolean includeProvince, Boolean includeWards);

    Optional<LocationDistrictEntity> findByName(String name, Boolean includeProvince, Boolean includeWards);

    List<LocationDistrictEntity> findAll();

    List<LocationDistrictEntity> findAll(Boolean includeProvince, Boolean includeWards);

    List<LocationDistrictEntity> findAll(Boolean includeProvince, Boolean includeWards, String orderBy, String sortType, Integer limit);

    List<LocationDistrictEntity> findAllByNameLike(String name, Boolean includeProvince, Boolean includeWards, String orderBy, String sortType, Integer limit);

    List<LocationDistrictEntity> findAllByProvinceId(String id, Boolean includeProvince, Boolean includeWards, String orderBy, String sortType, Integer limit);

    List<LocationDistrictEntity> findAllByProvinceCode(String code, Boolean includeProvince, Boolean includeWards, String orderBy, String sortType, Integer limit);

}
