package app.travel.shared.entity;

import app.travel.model.tours.TourEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.UUID;

@Component
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuditEntity implements MetaObjectHandler {

    @TableId
    @TableField("id")
    UUID id;

    @TableField("created_at")
    OffsetDateTime createdAt;

    @TableField("updated_at")
    OffsetDateTime updatedAt;

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "id", UUID::randomUUID, UUID.class);
        this.strictInsertFill(metaObject, "createdAt", OffsetDateTime::now, OffsetDateTime.class);
        this.strictInsertFill(metaObject, "updatedAt", OffsetDateTime::now, OffsetDateTime.class);

        Object originalObject = metaObject.getOriginalObject();

        if(originalObject instanceof TourEntity){

            String fieldBookingTicketsName = "bookingTickets";

            if(getFieldValByName(fieldBookingTicketsName, metaObject) == null){
                this.strictInsertFill(metaObject, fieldBookingTicketsName, () -> 0, Integer.class);
            }
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "updatedAt", OffsetDateTime::now, OffsetDateTime.class);
    }
}
