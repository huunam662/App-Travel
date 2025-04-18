package app.travel.common.constant.other;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum UploadType {

    DEFAULT_UPLOAD("store", "store"),
    PROFILE_USER("profile", "pfu-gallery"),
    TOUR_GALLERY("tour", "t-gallery"),
    FEEDBACK_GALLERY("feedback", "fb-gallery"),
    TOUR_TIMELINE("tour timeline", "ttl-gallery"),
    TOUR_TIMELINE_OVERVIEW("tour timeline overview", "ttl-ov-gallery");

    String type;
    String folder;

    UploadType(String type, String folder) {

        this.type = type;
        this.folder = folder;
    }

    public static final UploadType DEFAULT = DEFAULT_UPLOAD;

    public static UploadType fromType(String type) {

        if(type == null || type.isEmpty())
            return DEFAULT;

        return Arrays.stream(UploadType.values())
                .filter(t -> t.type.equalsIgnoreCase(type.trim()))
                .findFirst()
                .orElse(DEFAULT);
    }

    @Override
    public String toString() {
        return type;
    }
}
