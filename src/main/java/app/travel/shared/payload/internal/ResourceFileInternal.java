package app.travel.shared.payload.internal;

import app.travel.common.constant.CloudType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResourceFileInternal {

    String folderName;

    String ipAddressClient;

    CloudType cloudType;

    @Builder.ObtainVia
    @Setter(AccessLevel.NONE)
    final Long uploadTime = System.currentTimeMillis();

}
