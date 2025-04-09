package app.travel.model.tag_tours;

import app.travel.shared.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@TableName("tag_tours")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TagTourEntity extends BaseEntity {

    @TableField("tag_name")
    String tagName;

    @TableField("tag_type")
    String tagType;

}
