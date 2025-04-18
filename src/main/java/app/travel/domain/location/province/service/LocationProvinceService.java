package app.travel.domain.location.province.service;

import app.travel.advice.exception.templates.ErrorHolderException;
import app.travel.common.constant.other.Error;
import app.travel.domain.location.province.payload.request.LocationProvinceParams1Request;
import app.travel.domain.location.province.payload.request.LocationProvinceParams2Request;
import app.travel.model.location.provinces.entity.LocationProvinceEntity;
import app.travel.model.location.provinces.repository.ILocationProvinceRepository;
import app.travel.model.location.provinces.repository.LocationProvinceRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LocationProvinceService implements ILocationProvinceService {

    ILocationProvinceRepository provinceLocationRepository;
    private final LocationProvinceRepository locationProvinceRepository;

    @Override
    public LocationProvinceEntity getById(String id, LocationProvinceParams1Request params) {

        return provinceLocationRepository.findById(id, params.getIncludeDistricts(), params.getIncludeWards())
                .orElseThrow(
                        () -> new ErrorHolderException(Error.RESOURCE_NOT_FOUND)
                );
    }

    @Override
    public LocationProvinceEntity getByCodeName(String codeName, LocationProvinceParams1Request params) {

        return provinceLocationRepository.findByCodeName(codeName, params.getIncludeDistricts(), params.getIncludeWards())
                .orElseThrow(
                        () -> new ErrorHolderException(Error.RESOURCE_NOT_FOUND)
                );
    }

    @Override
    public LocationProvinceEntity getByName(String name, LocationProvinceParams1Request params) {

        return locationProvinceRepository.findByName(name, params.getIncludeDistricts(), params.getIncludeWards())
                .orElseThrow(
                        () -> new ErrorHolderException(Error.RESOURCE_NOT_FOUND)
                );
    }

    @Override
    public List<LocationProvinceEntity> getListProvinceLocation() {

        return provinceLocationRepository.findAll();
    }

    @Override
    public List<LocationProvinceEntity> getListProvinceLocation(LocationProvinceParams1Request params) {

        return provinceLocationRepository.findAll(
                params.getIncludeDistricts(),
                params.getIncludeWards()
        );
    }

    @Override
    public List<LocationProvinceEntity> getListByContainsName(String name, LocationProvinceParams2Request params) {

        return provinceLocationRepository.findAllByNameLike(
                name,
                params.getIncludeDistricts(),
                params.getIncludeWards(),
                params.getSortBy().getName(),
                params.getSortType().getValue(),
                params.getLimit()
        );
    }

    @Override
    public List<LocationProvinceEntity> getListProvinceLocations(LocationProvinceParams2Request params) {

        return provinceLocationRepository.findAll(
                params.getIncludeDistricts(),
                params.getIncludeWards(),
                params.getSortBy().getName(),
                params.getSortType().getValue(),
                params.getLimit()
        );
    }

}
