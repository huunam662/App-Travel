package app.travel.model.location.provinces.repository;

import app.travel.model.location.provinces.entity.LocationProvinceEntity;
import app.travel.model.location.provinces.mapper.LocationProvinceMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LocationProvinceRepository implements ILocationProvinceRepository {

    LocationProvinceMapper provinceLocationMapper;

    @Override
    public Optional<LocationProvinceEntity> findById(String id) {

        return findById(id, null, null);
    }

    @Override
    public Optional<LocationProvinceEntity> findById(String id, Boolean includeDistricts, Boolean includeWards) {

        return provinceLocationMapper.selectByIdWithJoinDistrictAndWard(id, includeDistricts, includeWards);
    }

    @Override
    public Optional<LocationProvinceEntity> findByCodeName(String codeName) {

        return findByCodeName(codeName, null, null);
    }

    @Override
    public Optional<LocationProvinceEntity> findByCodeName(String codeName, Boolean includeDistricts, Boolean includeWards) {

        return provinceLocationMapper.selectByCodeNameWithJoinDistrictAndWard(codeName, includeDistricts, includeWards);
    }

    @Override
    public List<LocationProvinceEntity> findAll() {

        return findAll(null, null);
    }

    @Override
    public List<LocationProvinceEntity> findAll(Boolean includeDistricts, Boolean includeWards) {

        return findAll(includeDistricts, includeWards, null, null, null);
    }

    @Override
    public List<LocationProvinceEntity> findAll(Boolean includeDistricts, Boolean includeWards, String orderBy, String sortType, Integer limit) {

        return provinceLocationMapper.selectListWithJoinDistrictAndWard(includeDistricts, includeWards, orderBy, sortType, limit);
    }

    @Override
    public List<LocationProvinceEntity> findAllByNameLike(String name, Boolean includeDistricts, Boolean includeWards, String orderBy, String sortType, Integer limit) {

        return provinceLocationMapper.selectListByNameLikeWithJoinDistrictAndWard(name, includeDistricts, includeWards, orderBy, sortType, limit);
    }

    @Override
    public Optional<LocationProvinceEntity> findByName(String name, Boolean includeDistricts, Boolean includeWards) {

        return provinceLocationMapper.selectByNameWithJoinDistrictAndWard(name, includeDistricts, includeWards);
    }
}
