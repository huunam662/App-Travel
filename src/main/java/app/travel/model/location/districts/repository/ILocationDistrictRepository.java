package app.travel.model.location.districts.repository;

import app.travel.model.location.districts.entity.LocationDistrictEntity;
import java.util.List;
import java.util.Optional;

public interface ILocationDistrictRepository {

    Optional<LocationDistrictEntity> findById(String id);

    Optional<LocationDistrictEntity> findById(String id, Boolean includeDistricts, Boolean includeWards);

    Optional<LocationDistrictEntity> findByCodeName(String codeName);

    Optional<LocationDistrictEntity> findByCodeName(String codeName, Boolean includeDistricts, Boolean includeWards);

    Optional<LocationDistrictEntity> findByName(String name, Boolean includeDistricts, Boolean includeWards);

    List<LocationDistrictEntity> findAll();

    List<LocationDistrictEntity> findAll(Boolean includeDistricts, Boolean includeWards);

    List<LocationDistrictEntity> findAll(Boolean includeDistricts, Boolean includeWards, String orderBy, String sortType, Integer limit);

    List<LocationDistrictEntity> findAllByNameLike(String name, Boolean includeDistricts, Boolean includeWards, String orderBy, String sortType, Integer limit);

}
