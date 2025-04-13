package app.travel.domain.location.ward.service;

import app.travel.advice.exception.templates.ErrorHolderException;
import app.travel.common.constant.Error;
import app.travel.domain.location.ward.payload.request.LocationWardParams1Request;
import app.travel.domain.location.ward.payload.request.LocationWardParams2Request;
import app.travel.model.location.wards.entity.LocationWardEntity;
import app.travel.model.location.wards.repository.ILocationWardRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LocationWardService implements ILocationWardService {

    ILocationWardRepository wardRepository;

    @Override
    public LocationWardEntity getById(String id, LocationWardParams1Request params) {

        return wardRepository.findById(id, params.getIncludeDistrict(), params.getIncludeProvince())
                .orElseThrow(
                        () -> new ErrorHolderException(Error.RESOURCE_NOT_FOUND)
                );
    }

    @Override
    public LocationWardEntity getByCodeName(String codeName, LocationWardParams1Request params) {

        return wardRepository.findByCodeName(codeName, params.getIncludeDistrict(), params.getIncludeProvince())
                .orElseThrow(
                        () -> new ErrorHolderException(Error.RESOURCE_NOT_FOUND)
                );
    }

    @Override
    public LocationWardEntity getByName(String name, LocationWardParams1Request params) {

        return wardRepository.findByName(name, params.getIncludeDistrict(), params.getIncludeProvince())
                .orElseThrow(
                        () -> new ErrorHolderException(Error.RESOURCE_NOT_FOUND)
                );
    }

    @Override
    public List<LocationWardEntity> getListWardLocation() {

        return wardRepository.findAll();
    }

    @Override
    public List<LocationWardEntity> getListWardLocation(LocationWardParams1Request params) {

        return wardRepository.findAll(
                params.getIncludeDistrict(),
                params.getIncludeProvince()
        );
    }

    @Override
    public List<LocationWardEntity> getListByContainsName(String name, LocationWardParams2Request params) {

        return wardRepository.findAllByNameLike(
                name,
                params.getIncludeDistrict(),
                params.getIncludeProvince(),
                params.getSortBy().getName(),
                params.getSortType().getValue(),
                params.getLimit()
        );
    }

    @Override
    public List<LocationWardEntity> getListWardLocation(LocationWardParams2Request params) {

        return wardRepository.findAll(
                params.getIncludeDistrict(),
                params.getIncludeProvince(),
                params.getSortBy().getName(),
                params.getSortType().getValue(),
                params.getLimit()
        );
    }

    @Override
    public List<LocationWardEntity> getListWardByDistrictId(String districtId, LocationWardParams2Request params) {

        return wardRepository.findAllByDistrictId(
                districtId,
                params.getIncludeDistrict(),
                params.getIncludeProvince(),
                params.getSortBy().getName(),
                params.getSortType().getValue(),
                params.getLimit()
        );
    }

    @Override
    public List<LocationWardEntity> getListWardByDistrictCode(String districtCode, LocationWardParams2Request params) {

        return wardRepository.findAllByDistrictCode(
                districtCode,
                params.getIncludeDistrict(),
                params.getIncludeProvince(),
                params.getSortBy().getName(),
                params.getSortType().getValue(),
                params.getLimit()
        );
    }

}
