package app.travel.model.packs_of_tour;

import app.travel.shared.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import java.util.UUID;

@TableName("packs_of_tour")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PackOfTourEntity extends BaseEntity {

    @TableField("tour_id")
    UUID tourId;

    @TableField("tour_pack_id")
    UUID tourPackId;

}
