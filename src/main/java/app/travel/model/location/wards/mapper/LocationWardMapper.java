package app.travel.model.location.wards.mapper;

import app.travel.model.location.districts.entity.LocationDistrictEntity;
import app.travel.model.location.wards.entity.LocationWardEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface LocationWardMapper {

    Optional<LocationWardEntity> selectByIdWithJoinDistrictAndProvince(
            @Param("id") String id,
            @Param("joinLocationDistrict") Boolean joinLocationDistrict,
            @Param("joinLocationProvince") Boolean joinLocationProvince
    );

    Optional<LocationWardEntity> selectByNameWithJoinDistrictAndProvince(
            @Param("name") String name,
            @Param("joinLocationDistrict") Boolean joinLocationDistrict,
            @Param("joinLocationProvince") Boolean joinLocationProvince
    );

    Optional<LocationWardEntity> selectByCodeNameWithJoinDistrictAndProvince(
            @Param("code") String code,
            @Param("joinLocationDistrict") Boolean joinLocationDistrict,
            @Param("joinLocationProvince") Boolean joinLocationProvince
    );

    List<LocationWardEntity> selectListWithJoinDistrictAndProvince(
            @Param("joinLocationDistrict") Boolean joinLocationDistrict,
            @Param("joinLocationProvince") Boolean joinLocationProvince,
            @Param("orderBy") String orderBy,
            @Param("sortType") String sortType,
            @Param("limit") Integer limit
    );

    List<LocationWardEntity> selectListByNameLikeWithJoinDistrictAndProvince(
            @Param("wardName") String wardName,
            @Param("joinLocationDistrict") Boolean joinLocationDistrict,
            @Param("joinLocationProvince") Boolean joinLocationProvince,
            @Param("orderBy") String orderBy,
            @Param("sortType") String sortType,
            @Param("limit") Integer limit
    );

    List<LocationWardEntity> selectListByDistrictIdWithJoinDistrictAndProvince(
            @Param("districtId") String districtId,
            @Param("joinLocationDistrict") Boolean joinLocationDistrict,
            @Param("joinLocationProvince") Boolean joinLocationProvince,
            @Param("orderBy") String orderBy,
            @Param("sortType") String sortType,
            @Param("limit") Integer limit
    );

    List<LocationWardEntity> selectListByDistrictCodeWithJoinDistrictAndProvince(
            @Param("districtCode") String districtCode,
            @Param("joinLocationDistrict") Boolean joinLocationDistrict,
            @Param("joinLocationProvince") Boolean joinLocationProvince,
            @Param("orderBy") String orderBy,
            @Param("sortType") String sortType,
            @Param("limit") Integer limit
    );

}
