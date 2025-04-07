package app.travel.common.constant.sort_by;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import java.util.Arrays;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum PlaceSortBy {

    UPDATE_AT("latest"),
    PLACE_NAME("place-name");

    String value;

    PlaceSortBy(String value) {

        if(value == null || value.isEmpty()) {
            this.value = "latest";
            return;
        }

        this.value = value;
    }

    public static PlaceSortBy fromValue(String value){

        return Arrays.stream(PlaceSortBy.values())
                .filter(
                        v -> v.getValue().equalsIgnoreCase(value)
                )
                .findFirst()
                .orElse(UPDATE_AT);
    }

}
