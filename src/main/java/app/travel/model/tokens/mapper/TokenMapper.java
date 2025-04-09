package app.travel.model.tokens.mapper;

import app.travel.model.tokens.entity.TokenEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import java.util.Optional;

@Mapper
public interface TokenMapper extends BaseMapper<TokenEntity> {

    @Select("SELECT * FROM tokens t WHERE t.token = #{token}")
    Optional<TokenEntity> selectByToken(@Param("token") String token);

}
