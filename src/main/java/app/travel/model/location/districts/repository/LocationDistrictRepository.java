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
    public Optional<LocationDistrictEntity> findById(String id, Boolean includeDistricts, Boolean includeWards) {

        return locationDistrictMapper.selectByIdWithJoinProvinceWards(
                id,
                includeDistricts,
                includeWards
        );
    }

    @Override
    public Optional<LocationDistrictEntity> findByCodeName(String codeName) {

        return findByCodeName(codeName, null, null);
    }

    @Override
    public Optional<LocationDistrictEntity> findByCodeName(String codeName, Boolean includeDistricts, Boolean includeWards) {

        return locationDistrictMapper.selectByCodeNameWithJoinProvinceWards(
                codeName,
                includeDistricts,
                includeWards
        );
    }

    @Override
    public Optional<LocationDistrictEntity> findByName(String name, Boolean includeDistricts, Boolean includeWards) {

        return locationDistrictMapper.selectByNameWithJoinProvinceWards(
                name,
                includeDistricts,
                includeWards
        );
    }

    @Override
    public List<LocationDistrictEntity> findAll() {

        return findAll(null, null);
    }

    @Override
    public List<LocationDistrictEntity> findAll(Boolean includeDistricts, Boolean includeWards) {

        return findAll(
                includeDistricts,
                includeWards,
                null,
                null,
                null
        );
    }

    @Override
    public List<LocationDistrictEntity> findAll(Boolean includeDistricts, Boolean includeWards, String orderBy, String sortType, Integer limit) {

        return locationDistrictMapper.selectListWithJoinProvinceWards(
                includeDistricts,
                includeWards,
                orderBy,
                sortType,
                limit
        );
    }

    @Override
    public List<LocationDistrictEntity> findAllByNameLike(String name, Boolean includeDistricts, Boolean includeWards, String orderBy, String sortType, Integer limit) {

        return locationDistrictMapper.selectListByNameLikeWithJoinProvinceWards(
                name,
                includeDistricts,
                includeWards,
                orderBy,
                sortType,
                limit
        );
    }
}
