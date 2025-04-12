package app.travel.model.location.provinces.repository;

import app.travel.model.location.provinces.entity.ProvinceLocationEntity;
import app.travel.model.location.provinces.mapper.ProvinceLocationMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProvinceLocationRepository implements IProvinceLocationRepository{

    ProvinceLocationMapper provinceLocationMapper;

    @Override
    public Optional<ProvinceLocationEntity> findById(String id) {

        return Optional.ofNullable(provinceLocationMapper.selectById(id));
    }

    @Override
    public Optional<ProvinceLocationEntity> findById(String id, Boolean includeDistricts, Boolean includeWards) {

        if(!includeDistricts && !includeWards)
            return findById(id);

        return provinceLocationMapper.selectByIdWithJoinDistrictAndWard(id, includeDistricts, includeWards);
    }

    @Override
    public Optional<ProvinceLocationEntity> findByCodeName(String codeName) {

        return provinceLocationMapper.selectByCodeName(codeName);
    }

    @Override
    public Optional<ProvinceLocationEntity> findByCodeName(String codeName, Boolean includeDistricts, Boolean includeWards) {

        if(!includeDistricts && !includeWards)
            return findByCodeName(codeName);

        return provinceLocationMapper.selectByCodeNameWithJoinDistrictAndWard(codeName, includeDistricts, includeWards);
    }

    @Override
    public List<ProvinceLocationEntity> findAll() {

        return provinceLocationMapper.selectList(new QueryWrapper<>());
    }

    @Override
    public List<ProvinceLocationEntity> findAll(Boolean includeDistricts, Boolean includeWards) {

        return provinceLocationMapper.selectListWithJoinDistrictAndWard(includeDistricts, includeWards, null, null, null);
    }

    @Override
    public List<ProvinceLocationEntity> findAll(Boolean includeDistricts, Boolean includeWards, String orderBy, String sortDirection, int limit) {

        return provinceLocationMapper.selectListWithJoinDistrictAndWard(includeDistricts, includeWards, orderBy, sortDirection, limit);
    }

    @Override
    public List<ProvinceLocationEntity> findAllByNameLike(String name, Boolean includeDistricts, Boolean includeWards, String orderBy, String sortDirection, int limit) {

        return provinceLocationMapper.selectListByNameLikeWithJoinDistrictAndWard(name, includeDistricts, includeWards, orderBy, sortDirection, limit);
    }
}
