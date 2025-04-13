package app.travel.model.location.districts.mapper;

import app.travel.model.location.districts.entity.LocationDistrictEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface LocationDistrictMapper {

    Optional<LocationDistrictEntity> selectByIdWithJoinProvinceWards(
            @Param("id") String id,
            @Param("includeProvince") Boolean includeProvince,
            @Param("includeWards") Boolean includeWards
    );

    Optional<LocationDistrictEntity> selectByCodeNameWithJoinProvinceWards(
            @Param("code") String code,
            @Param("includeProvince") Boolean includeProvince,
            @Param("includeWards") Boolean includeWards
    );

    Optional<LocationDistrictEntity> selectByNameWithJoinProvinceWards(
            @Param("name") String name,
            @Param("includeProvince") Boolean includeProvince,
            @Param("includeWards") Boolean includeWards
    );

    List<LocationDistrictEntity> selectListWithJoinProvinceWards(
            @Param("includeProvince") Boolean includeProvince,
            @Param("includeWards") Boolean includeWards,
            @Param("orderBy") String orderBy,
            @Param("sortType") String sortType,
            @Param("limit") Integer limit
    );

    List<LocationDistrictEntity> selectListByNameLikeWithJoinProvinceWards(
            @Param("districtName") String districtName,
            @Param("includeProvince") Boolean includeProvince,
            @Param("includeWards") Boolean includeWards,
            @Param("orderBy") String orderBy,
            @Param("sortType") String sortType,
            @Param("limit") Integer limit
    );

}
