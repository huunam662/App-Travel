package app.travel.converter;

import app.travel.domain.location.ward.payload.response.LocationWardDistrictProvinceResponse;
import app.travel.model.location.wards.entity.LocationWardEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(builder = @Builder(disableBuilder = true), unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LocationWardConverter {

    LocationWardConverter INSTANCE = Mappers.getMapper(LocationWardConverter.class);

    LocationWardDistrictProvinceResponse toLocationWardDistrictProvinceResponse(LocationWardEntity locationWard);

    List<LocationWardDistrictProvinceResponse> toListLocationWardDistrictProvinceResponse(List<LocationWardEntity> locationWardList);

}
