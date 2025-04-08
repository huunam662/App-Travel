package app.travel.config.mybatis.hander;

import app.travel.model.tours.TourEntity;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import java.time.OffsetDateTime;
import java.util.UUID;

@Configuration
public class MetaObjectHandlerConfig implements MetaObjectHandler {

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
