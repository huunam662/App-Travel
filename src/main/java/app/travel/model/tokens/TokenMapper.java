package app.travel.model.tokens;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.Optional;
import java.util.UUID;

@Mapper
public interface TokenMapper extends BaseMapper<TokenEntity> {

    @Select("SELECT * FROM tokens t " +
            "WHERE t.id = #{id}"
    )
    Optional<TokenEntity> findById(@Param("id") UUID id);

    @Select("SELECT * FROM tokens t " +
            "WHERE t.token = #{token}"
    )
    Optional<TokenEntity> findByToken(@Param("token") String token);

}
