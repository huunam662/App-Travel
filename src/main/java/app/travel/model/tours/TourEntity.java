package app.travel.model.tours;

import app.travel.model.founder_tours.entity.FounderTourEntity;
import app.travel.model.places.entity.PlaceEntity;
import app.travel.model.tag_tours.TagTourEntity;
import app.travel.shared.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import java.util.List;
import java.util.UUID;

@TableName("tours")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TourEntity extends BaseEntity{

    @TableField("founder_tour_id")
    UUID founderTourId;

    @TableField("tag_tour_id")
    UUID tagTourId;

    @TableField("place_depart_id")
    UUID placeDepartId;

    @TableField("place_travel_id")
    UUID placeTravelId;

    @TableField("tour_name")
    String tourName;

    @TableField("tour_code")
    String tourCode;

    @TableField("extension_items")
    String extensionItems;

    @TableField("rating_avg")
    Float ratingAvg;

    @TableField("tour_experience_html")
    String tourExperienceHtml;

    @TableField("tour_video_url")
    String tourVideoUrl;

    @TableField(value = "booking_tickets", fill = FieldFill.INSERT_UPDATE)
    Integer bookingTickets;

    @TableField(exist = false)
    FounderTourEntity founder;

    @TableField(exist = false)
    TagTourEntity tag;

    @TableField(exist = false)
    PlaceEntity placeDepart;

    @TableField(exist = false)
    PlaceEntity placeTravel;

    @TableField(exist = false)
    List<PlaceEntity> trips;

}
