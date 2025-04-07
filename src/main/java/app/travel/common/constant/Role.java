package app.travel.common.constant;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import java.util.Arrays;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum Role implements IEnum<String> {

    TOURIST("TOURIST", "TOURIST"),
    FOUNDER("FOUNDER", "FOUNDER"),
    SUPER_ADMIN("SUPER_ADMIN", "SUPER ADMIN");

    String valueDb;
    String prettyRoleName;

    Role(String valueDb, String prettyRoleName){
        this.valueDb = valueDb;
        this.prettyRoleName = prettyRoleName;
    }

    public static Role fromPrettyRoleName(String prettyRoleName){
        return Arrays.stream(Role.values())
                .filter(
                        role -> role.getPrettyRoleName().equalsIgnoreCase(prettyRoleName)
                )
                .findFirst()
                .orElse(TOURIST);
    }

    public static Role fromAuthority(GrantedAuthority authority){

        if(authority == null) return Role.TOURIST;

        if(authority.getAuthority() == null) return Role.TOURIST;

        String roleName =  authority.getAuthority().substring("ROLE_".length()).trim();

        return Arrays.stream(Role.values())
                .filter(
                        role -> role.name().equalsIgnoreCase(roleName)
                )
                .findFirst()
                .orElse(TOURIST);
    }

    @Override
    public String getValue() {
        return valueDb;
    }
}
