package app.travel.common.constant;

import app.travel.common.constant.sort_by.PlaceSortBy;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum SortDirection {

    ASC("ASC"),
    DESC("DESC");

    String value;

    SortDirection(String value) {

        if(value == null || value.isEmpty()) {
            this.value = "DESC";
            return;
        }

        this.value = value;
    }

    public static SortDirection fromValue(String value){

        return Arrays.stream(SortDirection.values())
                .filter(
                        v -> v.getValue().equalsIgnoreCase(value)
                )
                .findFirst()
                .orElse(DESC);
    }

}
