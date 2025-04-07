package app.travel.model.places;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.Optional;
import java.util.UUID;

@Mapper
public interface PlaceMapper {

    @Select("SELECT * FROM places p WHERE p.id = #{id}")
    Optional<PlaceEntity> findById(@Param("id") UUID id);

}
