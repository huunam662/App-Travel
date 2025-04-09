package app.travel.config.mybatis.hander;

import app.travel.model.tours.TourEntity;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Slf4j(topic = "META-OBJECT-HANDLER")
public class MetaObjectHandlerConfig implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {

        log.info("Meta Object Handler insert fill");

        setFieldValByName("id", UUID.randomUUID(), metaObject);
        setFieldValByName("createdAt", OffsetDateTime.now(ZoneId.systemDefault()), metaObject);
        setFieldValByName("updatedAt", OffsetDateTime.now(ZoneId.systemDefault()), metaObject);

        Object originalObject = metaObject.getOriginalObject();

        if(originalObject instanceof TourEntity){

            String fieldBookingTicketsName = "bookingTickets";

            Object fieldBookingTickets = getFieldValByName(fieldBookingTicketsName, metaObject);

            if(fieldBookingTickets == null){
                setFieldValByName(fieldBookingTicketsName, 0, metaObject);
            }
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {

        log.info("Meta Object Handler update fill");

        setFieldValByName("updatedAt", OffsetDateTime.now(ZoneId.systemDefault()), metaObject);
    }
}
