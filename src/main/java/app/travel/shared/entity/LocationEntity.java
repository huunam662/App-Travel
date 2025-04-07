package app.travel.shared.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocationEntity {

    @TableId
    @TableField("id")
    String id;

    @TableField("name")
    String name;

    @TableField("name_en")
    String nameEn;

    @TableField("full_name")
    String fullName;

    @TableField("full_name_en")
    String fullNameEn;

    @TableField("code_name")
    String codeName;

}
