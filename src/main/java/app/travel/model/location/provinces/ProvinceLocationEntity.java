package app.travel.model.location.provinces;

import app.travel.shared.entity.LocationBaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@TableName("provinces_location")
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProvinceLocationEntity extends LocationBaseEntity {
}
