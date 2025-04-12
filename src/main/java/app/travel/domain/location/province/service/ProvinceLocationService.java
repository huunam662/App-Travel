package app.travel.domain.location.province.service;

import app.travel.advice.exception.templates.ErrorHolderException;
import app.travel.common.constant.Error;
import app.travel.model.location.provinces.entity.ProvinceLocationEntity;
import app.travel.model.location.provinces.repository.IProvinceLocationRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProvinceLocationService implements IProvinceLocationService{

    IProvinceLocationRepository provinceLocationRepository;

    @Override
    public ProvinceLocationEntity getById(String id, Boolean includeDistricts, Boolean includeWards) {

        return provinceLocationRepository.findById(id, includeDistricts, includeWards)
                .orElseThrow(
                        () -> new ErrorHolderException(Error.RESOURCE_NOT_FOUND)
                );
    }

    @Override
    public ProvinceLocationEntity getByCodeName(String codeName, Boolean includeDistricts, Boolean includeWards) {

        return provinceLocationRepository.findByCodeName(codeName, includeDistricts, includeWards)
                .orElseThrow(
                        () -> new ErrorHolderException(Error.RESOURCE_NOT_FOUND)
                );
    }

    @Override
    public List<ProvinceLocationEntity> getListProvinceLocation() {

        return provinceLocationRepository.findAll();
    }

    @Override
    public List<ProvinceLocationEntity> getListProvinceLocation(Boolean includeDistricts, Boolean includeWards) {

        if(!includeDistricts && !includeWards)
            return getListProvinceLocation();

        return provinceLocationRepository.findAll(includeDistricts, includeWards);
    }

    @Override
    public List<ProvinceLocationEntity> getListByContainsName(String name, Boolean includeDistricts, Boolean includeWards, String orderBy, String sortDirection, int limit) {

        return provinceLocationRepository.findAllByNameLike(
                name, includeDistricts, includeWards, orderBy, sortDirection, limit
        );
    }

    @Override
    public List<ProvinceLocationEntity> getListProvinceLocations(Boolean includeDistricts, Boolean includeWards, String orderBy, String sortDirection, int limit) {

        return provinceLocationRepository.findAll(
                includeDistricts, includeWards, orderBy, sortDirection, limit
        );
    }
}
