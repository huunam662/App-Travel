package app.travel.shared.payload.internal;

import app.travel.common.constant.other.CloudType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResourceFileInternal {

    String folderName;

    CloudType cloudType;

    @Builder.ObtainVia
    @Setter(AccessLevel.NONE)
    final UUID unique = UUID.randomUUID();

    @Builder.ObtainVia
    @Setter(AccessLevel.NONE)
    final long timestamp = System.currentTimeMillis();

}
