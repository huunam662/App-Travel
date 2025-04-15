package app.travel.shared.payload.internal;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.core.io.Resource;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoadResourceInternal {

    Resource resource;

    String resourceFormat;

    String resourceType;

}
