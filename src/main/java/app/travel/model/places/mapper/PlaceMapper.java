package app.travel.model.places.mapper;

import app.travel.model.places.entity.PlaceEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PlaceMapper extends BaseMapper<PlaceEntity> {

    @Select("SELECT * FROM places p WHERE p.place_name = #{name}")
    Optional<PlaceEntity> selectByName(@Param("name") String name);

    @Select("SELECT * FROM places p WHERE p.is_foreign = #{isForeign}")
    List<PlaceEntity> selectListByIsForeign(@Param("isForeign") Boolean isForeign);

}
