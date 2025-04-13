package app.travel.model.location.districts.repository;

import app.travel.model.location.districts.entity.LocationDistrictEntity;
import app.travel.model.location.districts.mapper.LocationDistrictMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LocationDistrictRepository implements ILocationDistrictRepository{

    LocationDistrictMapper locationDistrictMapper;

    @Override
    public Optional<LocationDistrictEntity> findById(String id) {

        return findById(id, null, null);
    }

    @Override
    public Optional<LocationDistrictEntity> findById(String id, Boolean includeProvince, Boolean includeWards) {

        return locationDistrictMapper.selectByIdWithJoinProvinceWards(
                id,
                includeProvince,
                includeWards
        );
    }

    @Override
    public Optional<LocationDistrictEntity> findByCodeName(String codeName) {

        return findByCodeName(codeName, null, null);
    }

    @Override
    public Optional<LocationDistrictEntity> findByCodeName(String codeName, Boolean includeProvince, Boolean includeWards) {

        return locationDistrictMapper.selectByCodeNameWithJoinProvinceWards(
                codeName,
                includeProvince,
                includeWards
        );
    }

    @Override
    public Optional<LocationDistrictEntity> findByName(String name, Boolean includeProvince, Boolean includeWards) {

        return locationDistrictMapper.selectByNameWithJoinProvinceWards(
                name,
                includeProvince,
                includeWards
        );
    }

    @Override
    public List<LocationDistrictEntity> findAll() {

        return findAll(null, null);
    }

    @Override
    public List<LocationDistrictEntity> findAll(Boolean includeProvince, Boolean includeWards) {

        return findAll(
                includeProvince,
                includeWards,
                null,
                null,
                null
        );
    }

    @Override
    public List<LocationDistrictEntity> findAll(Boolean includeProvince, Boolean includeWards, String orderBy, String sortType, Integer limit) {

        return locationDistrictMapper.selectListWithJoinProvinceWards(
                includeProvince,
                includeWards,
                orderBy,
                sortType,
                limit
        );
    }

    @Override
    public List<LocationDistrictEntity> findAllByNameLike(String name, Boolean includeProvince, Boolean includeWards, String orderBy, String sortType, Integer limit) {

        return locationDistrictMapper.selectListByNameLikeWithJoinProvinceWards(
                name,
                includeProvince,
                includeWards,
                orderBy,
                sortType,
                limit
        );
    }

    @Override
    public List<LocationDistrictEntity> findAllByProvinceId(String id, Boolean includeProvince, Boolean includeWards, String orderBy, String sortType, Integer limit) {

        return locationDistrictMapper.selectListByProvinceIdWithJoinProvinceWards(
                id,
                includeProvince,
                includeWards,
                orderBy,
                sortType,
                limit
        );
    }

    @Override
    public List<LocationDistrictEntity> findAllByProvinceCode(String code, Boolean includeProvince, Boolean includeWards, String orderBy, String sortType, Integer limit) {

        return locationDistrictMapper.selectListByProvinceCodeWithJoinProvinceWards(
            code,
            includeProvince,
            includeWards,
            orderBy,
            sortType,
            limit
        );
    }
}
