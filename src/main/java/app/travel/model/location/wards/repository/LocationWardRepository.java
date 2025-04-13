package app.travel.model.location.wards.repository;

import app.travel.model.location.wards.entity.LocationWardEntity;
import app.travel.model.location.wards.mapper.LocationWardMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LocationWardRepository implements ILocationWardRepository{

    LocationWardMapper locationWardMapper;

    @Override
    public Optional<LocationWardEntity> findById(String id) {

        return findById(id, null, null);
    }

    @Override
    public Optional<LocationWardEntity> findById(String id, Boolean includeDistrict, Boolean includeProvince) {

        return locationWardMapper.selectByIdWithJoinDistrictAndProvince(id, includeDistrict, includeProvince);
    }

    @Override
    public Optional<LocationWardEntity> findByCodeName(String codeName) {

        return findByCodeName(codeName, null, null);
    }

    @Override
    public Optional<LocationWardEntity> findByCodeName(String codeName, Boolean includeDistrict, Boolean includeProvince) {

        return locationWardMapper.selectByCodeNameWithJoinDistrictAndProvince(codeName, includeDistrict, includeProvince);
    }

    @Override
    public Optional<LocationWardEntity> findByName(String name, Boolean includeDistrict, Boolean includeProvince) {

        return locationWardMapper.selectByNameWithJoinDistrictAndProvince(name, includeDistrict, includeProvince);
    }

    @Override
    public List<LocationWardEntity> findAll() {

        return findAll(null, null);
    }

    @Override
    public List<LocationWardEntity> findAll(Boolean includeDistrict, Boolean includeProvince) {

        return findAll(includeDistrict, includeProvince, null, null, null);
    }

    @Override
    public List<LocationWardEntity> findAll(Boolean includeDistrict, Boolean includeProvince, String orderBy, String sortType, Integer limit) {

        return locationWardMapper.selectListWithJoinDistrictAndProvince(includeDistrict, includeProvince, orderBy, sortType, limit);
    }

    @Override
    public List<LocationWardEntity> findAllByNameLike(String name, Boolean includeDistrict, Boolean includeProvince, String orderBy, String sortType, Integer limit) {

        return locationWardMapper.selectListByNameLikeWithJoinDistrictAndProvince(
                name,
                includeDistrict,
                includeProvince,
                orderBy,
                sortType,
                limit
        );
    }

    @Override
    public List<LocationWardEntity> findAllByDistrictId(String id, Boolean includeDistrict, Boolean includeProvince, String orderBy, String sortType, Integer limit) {

        return locationWardMapper.selectListByDistrictIdWithJoinDistrictAndProvince(
                id,
                includeDistrict,
                includeProvince,
                orderBy,
                sortType,
                limit
        );
    }

    @Override
    public List<LocationWardEntity> findAllByDistrictCode(String code, Boolean includeDistrict, Boolean includeProvince, String orderBy, String sortType, Integer limit) {

        return locationWardMapper.selectListByDistrictCodeWithJoinDistrictAndProvince(
                code,
                includeDistrict,
                includeProvince,
                orderBy,
                sortType,
                limit
        );
    }
}
