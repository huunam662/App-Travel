package app.travel.model.schedules_booking_tour;

import app.travel.shared.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@TableName("schedules_booking_tour")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ScheduleBookingTourEntity extends BaseEntity {

    @TableField("tour_id")
    UUID tourId;

    @TableField("hotel_id")
    UUID hotelId;

    @TableField("start_date")
    OffsetDateTime startDate;

    @TableField("end_date")
    OffsetDateTime endDate;

    @TableField("remaining_tickets")
    Integer remainingTickets;

    @TableField("tickets_status")
    Boolean ticketsStatus;

    @TableField("money")
    BigDecimal money;

    @TableField("money_type")
    String moneyType;

}
