package app.travel.common.constant.other;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum ContentDispositionType {

    INLINE("inline", "display"),
    ATTACHMENT("attachment", "download");

    String contentDisposition;
    String typeResponse;

    ContentDispositionType(String contentDisposition, String typeResponse) {
        this.contentDisposition = contentDisposition;
        this.typeResponse = typeResponse;
    }

    public static final ContentDispositionType DEFAULT = INLINE;

    public static ContentDispositionType fromTypeResponse(String typeResponse) {

        if(typeResponse == null || typeResponse.isEmpty())
            return INLINE;

        return Arrays.stream(ContentDispositionType.values())
                .filter(
                    cdt -> cdt.typeResponse.equalsIgnoreCase(typeResponse)
                ).findFirst()
                .orElse(DEFAULT);
    }

    @Override
    public String toString() {

        return typeResponse;
    }
}
