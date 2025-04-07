package app.travel.model.bookings_tour;

import app.travel.shared.entity.AuditEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.UUID;

@TableName("bookings_tour")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingTourEntity extends AuditEntity {

    @TableField("schedules_tour_id")
    UUID schedulesTourId;

    @TableField("user_id")
    UUID userId;

    @TableField("tickets_number")
    Integer ticketsNumber;

    @TableField("money_tour")
    BigDecimal moneyTour;

    @TableField("money_tour_type")
    String moneyTourType;

    @TableField("booking_status")
    Boolean bookingStatus;

    @TableField("tour_image_url")
    String tourImageUrl;

}
