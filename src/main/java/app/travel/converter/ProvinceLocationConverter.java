package app.travel.converter;

import app.travel.domain.location.province.payload.response.ProvinceDistrictsLocationResponse;
import app.travel.domain.location.province.payload.response.ProvinceLocationResponse;
import app.travel.model.location.provinces.entity.ProvinceLocationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ProvinceLocationConverter {

    ProvinceLocationConverter INSTANCE = Mappers.getMapper(ProvinceLocationConverter.class);

    ProvinceLocationResponse toProvinceLocationResponse(ProvinceLocationEntity provinceLocation);

    ProvinceDistrictsLocationResponse toProvinceDistrictsLocation(ProvinceLocationEntity provinceLocation);

}
