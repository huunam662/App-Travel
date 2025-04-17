package app.travel.converter;

import app.travel.domain.location.district.payload.response.LocationDistrictProvinceWardsResponse;
import app.travel.model.location.districts.entity.LocationDistrictEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(builder = @Builder(disableBuilder = true), unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LocationDistrictConverter {

    LocationDistrictConverter INSTANCE = Mappers.getMapper(LocationDistrictConverter.class);

    LocationDistrictProvinceWardsResponse toLocationDistrictProvinceWardsResponse(LocationDistrictEntity locationDistrict);

    List<LocationDistrictProvinceWardsResponse> toListLocationDistrictProvinceWardsResponse(List<LocationDistrictEntity> locationDistrictList);

}
