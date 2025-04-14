package app.travel.model.profile_user.mapper;

import app.travel.model.profile_user.entity.ProfileUserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;
import java.util.UUID;

@Mapper
public interface ProfileUserMapper extends BaseMapper<ProfileUserEntity> {

    @Select("SELECT EXISTS(SELECT p.phone_number FROM profile_user p " +
            "WHERE p.phone_number = #{phoneNumber}" +
            ")"
    )
    Boolean isExistsByPhoneNumber(@Param("phoneNumber") String phoneNumber);

    Optional<ProfileUserEntity> selectByUserIdWithJoinUser(@Param("userId") UUID userId);

}
