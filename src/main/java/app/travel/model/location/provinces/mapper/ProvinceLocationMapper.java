package app.travel.model.location.provinces.mapper;

import app.travel.model.location.provinces.entity.ProvinceLocationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;


@Mapper
public interface ProvinceLocationMapper extends BaseMapper<ProvinceLocationEntity> {

    @Select("SELECT * FROM provinces_location p WHERE p.code_name = #{code}")
    Optional<ProvinceLocationEntity> selectByCodeName(@Param("code") String code);

    Optional<ProvinceLocationEntity> selectByIdWithJoinDistrictAndWard(
            @Param("id") String id,
            @Param("joinDistrictLocation") Boolean joinDistrictLocation,
            @Param("joinWardLocation") Boolean joinWardLocation
    );

    Optional<ProvinceLocationEntity> selectByCodeNameWithJoinDistrictAndWard(
            @Param("code") String code,
            @Param("joinDistrictLocation") Boolean joinDistrictLocation,
            @Param("joinWardLocation") Boolean joinWardLocation
    );

    List<ProvinceLocationEntity> selectListWithJoinDistrictAndWard(
            @Param("joinDistrictLocation") Boolean joinDistrictLocation,
            @Param("joinWardLocation") Boolean joinWardLocation
    );

    List<ProvinceLocationEntity> selectListWithJoinDistrictAndWard(
            @Param("joinDistrictLocation") Boolean joinDistrictLocation,
            @Param("joinWardLocation") Boolean joinWardLocation,
            @Param("orderBy") String orderBy,
            @Param("sortDirection") String sortDirection,
            @Param("limit") Integer limit
    );

    List<ProvinceLocationEntity> selectListByNameLikeWithJoinDistrictAndWard(
            @Param("provinceName") String provinceName,
            @Param("joinDistrictLocation") Boolean joinDistrictLocation,
            @Param("joinWardLocation") Boolean joinWardLocation,
            @Param("orderBy") String orderBy,
            @Param("sortDirection") String sortDirection,
            @Param("limit") Integer limit
    );

}
