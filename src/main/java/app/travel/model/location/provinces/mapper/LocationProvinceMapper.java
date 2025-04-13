package app.travel.model.location.provinces.mapper;

import app.travel.model.location.provinces.entity.LocationProvinceEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Optional;


@Mapper
public interface LocationProvinceMapper extends BaseMapper<LocationProvinceEntity> {

    Optional<LocationProvinceEntity> selectByIdWithJoinDistrictAndWard(
            @Param("id") String id,
            @Param("joinLocationDistrict") Boolean joinLocationDistrict,
            @Param("joinLocationWard") Boolean joinLocationWard
    );

    Optional<LocationProvinceEntity> selectByNameWithJoinDistrictAndWard(
            @Param("name") String name,
            @Param("joinLocationDistrict") Boolean joinLocationDistrict,
            @Param("joinLocationWard") Boolean joinLocationWard
    );

    Optional<LocationProvinceEntity> selectByCodeNameWithJoinDistrictAndWard(
            @Param("code") String code,
            @Param("joinLocationDistrict") Boolean joinLocationDistrict,
            @Param("joinLocationWard") Boolean joinLocationWard
    );

    List<LocationProvinceEntity> selectListWithJoinDistrictAndWard(
            @Param("joinLocationDistrict") Boolean joinLocationDistrict,
            @Param("joinLocationWard") Boolean joinLocationWard,
            @Param("orderBy") String orderBy,
            @Param("sortType") String sortType,
            @Param("limit") Integer limit
    );

    List<LocationProvinceEntity> selectListByNameLikeWithJoinDistrictAndWard(
            @Param("provinceName") String provinceName,
            @Param("joinLocationDistrict") Boolean joinLocationDistrict,
            @Param("joinLocationWard") Boolean joinLocationWard,
            @Param("orderBy") String orderBy,
            @Param("sortType") String sortType,
            @Param("limit") Integer limit
    );

}
