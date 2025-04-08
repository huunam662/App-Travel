package app.travel.model.tokens;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import java.util.Optional;

@Mapper
public interface TokenMapper extends BaseMapper<TokenEntity> {

    @Select("SELECT * FROM tokens t WHERE t.token = #{token}")
    Optional<TokenEntity> selectByToken(@Param("token") String token);

}
