package app.travel.model.profile_user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProfileUserMapper {

    @Select("SELECT EXISTS(SELECT p.phone_number FROM profile_user p WHERE p.phone_number = #{phoneNumber})")
    Boolean isExistsByPhoneNumber(@Param("phoneNumber") String phoneNumber);

}
