package app.travel.model.place_travels;

import app.travel.shared.entity.AuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Table(name = "place_travels")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlaceTravelEntity extends AuditEntity {

    @JoinColumn(name = "tour_id")
    UUID tourId;

    @JoinColumn(name = "place_id")
    UUID placeId;

}
