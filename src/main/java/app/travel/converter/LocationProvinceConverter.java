package app.travel.converter;

import app.travel.domain.location.province.payload.response.LocationProvinceDistrictsWardsResponse;
import app.travel.model.location.provinces.entity.LocationProvinceEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(builder = @Builder(disableBuilder = true), unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LocationProvinceConverter {

    LocationProvinceConverter INSTANCE = Mappers.getMapper(LocationProvinceConverter.class);

    LocationProvinceDistrictsWardsResponse toLocationProvinceDistrictsWardsResponse(LocationProvinceEntity provinceLocation);

    List<LocationProvinceDistrictsWardsResponse> toListLocationProvinceDistrictsWardsResponse(List<LocationProvinceEntity> provinceLocations);

}
