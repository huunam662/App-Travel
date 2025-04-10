package app.travel.common.constant.sort_by;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import java.util.Arrays;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum PlaceSortBy {

    UPDATE_AT("latest", "updated_at"),
    PLACE_NAME("name", "place_name");

    String value;
    String column;

    PlaceSortBy(String value, String column) {

        if(value == null || value.isEmpty())
            this.value = "latest";
        else this.value = value;

        if(column == null || column.isEmpty())
            this.column = "updated_at";
        else this.column = column;
    }

    @JsonCreator
    public static PlaceSortBy fromValue(String value){

        return Arrays.stream(PlaceSortBy.values())
                .filter(
                        v -> v.getValue().equalsIgnoreCase(value)
                )
                .findFirst()
                .orElse(UPDATE_AT);
    }

    public static PlaceSortBy fromColumn(String column){

        return Arrays.stream(PlaceSortBy.values())
                .filter(
                        v -> v.getColumn().equalsIgnoreCase(column)
                )
                .findFirst()
                .orElse(UPDATE_AT);
    }


    @Override
    public String toString() {
        return value;
    }
}
