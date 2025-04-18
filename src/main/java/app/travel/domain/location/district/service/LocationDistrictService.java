package app.travel.domain.location.district.service;

import app.travel.advice.exception.templates.ErrorHolderException;
import app.travel.common.constant.other.Error;
import app.travel.domain.location.district.payload.request.LocationDistrictParams1Request;
import app.travel.domain.location.district.payload.request.LocationDistrictParams2Request;
import app.travel.model.location.districts.entity.LocationDistrictEntity;
import app.travel.model.location.districts.repository.LocationDistrictRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LocationDistrictService implements ILocationDistrictService{

    LocationDistrictRepository locationDistrictRepository;

    @Override
    public LocationDistrictEntity getById(String id, LocationDistrictParams1Request params) {

        return locationDistrictRepository.findById(id, params.getIncludeProvince(), params.getIncludeWards())
                .orElseThrow(
                        () -> new ErrorHolderException(Error.RESOURCE_NOT_FOUND)
                );
    }

    @Override
    public LocationDistrictEntity getByCodeName(String codeName, LocationDistrictParams1Request params) {

        return locationDistrictRepository.findByCodeName(codeName, params.getIncludeProvince(), params.getIncludeWards())
                .orElseThrow(
                        () -> new ErrorHolderException(Error.RESOURCE_NOT_FOUND)
                );
    }

    @Override
    public LocationDistrictEntity getByName(String name, LocationDistrictParams1Request params) {

        return locationDistrictRepository.findByName(name, params.getIncludeProvince(), params.getIncludeWards())
                .orElseThrow(
                        () -> new ErrorHolderException(Error.RESOURCE_NOT_FOUND)
                );
    }

    @Override
    public List<LocationDistrictEntity> getListDistrictLocation() {

        return locationDistrictRepository.findAll();
    }

    @Override
    public List<LocationDistrictEntity> getListDistrictLocation(LocationDistrictParams1Request params) {

        return locationDistrictRepository.findAll(params.getIncludeProvince(), params.getIncludeWards());
    }

    @Override
    public List<LocationDistrictEntity> getListByContainsName(String name, LocationDistrictParams2Request params) {

        return locationDistrictRepository.findAllByNameLike(
                name,
                params.getIncludeProvince(),
                params.getIncludeWards(),
                params.getSortBy().getName(),
                params.getSortType().getValue(),
                params.getLimit()
        );
    }

    @Override
    public List<LocationDistrictEntity> getListDistrictLocation(LocationDistrictParams2Request params) {

        return locationDistrictRepository.findAll(
                params.getIncludeProvince(),
                params.getIncludeWards(),
                params.getSortBy().getName(),
                params.getSortType().getValue(),
                params.getLimit()
        );
    }

    @Override
    public List<LocationDistrictEntity> getListDistrictByProvinceId(String provinceId, LocationDistrictParams2Request params) {

        return locationDistrictRepository.findAllByProvinceId(
                provinceId,
                params.getIncludeProvince(),
                params.getIncludeWards(),
                params.getSortBy().getName(),
                params.getSortType().getValue(),
                params.getLimit()
        );
    }

    @Override
    public List<LocationDistrictEntity> getListDistrictByProvinceCode(String provinceCode, LocationDistrictParams2Request params) {

        return locationDistrictRepository.findAllByProvinceCode(
                provinceCode,
                params.getIncludeProvince(),
                params.getIncludeWards(),
                params.getSortBy().getName(),
                params.getSortType().getValue(),
                params.getLimit()
        );
    }

}
