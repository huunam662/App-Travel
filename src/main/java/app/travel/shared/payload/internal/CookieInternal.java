package app.travel.shared.payload.internal;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CookieInternal {

    String key;

    String value;

    @Builder.Default
    String path = "/";

    Integer maxAge;

    public Integer getMaxAge() {
        return maxAge / 1000;
    }
}
