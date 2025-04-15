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

        this.value = value;
        this.column = column;
    }

    public static final PlaceSortBy DEFAULT = UPDATE_AT;

    public static PlaceSortBy fromValue(String value){

        if(value == null || value.isEmpty())
            return UPDATE_AT;

        String valueTrim = value.trim();

        return Arrays.stream(PlaceSortBy.values())
                .filter(
                        v -> v.getValue().equalsIgnoreCase(valueTrim)
                )
                .findFirst()
                .orElse(UPDATE_AT);
    }

    public static PlaceSortBy fromColumn(String column){

        if(column == null || column.isEmpty())
            return UPDATE_AT;

        String columnTrim = column.trim();

        return Arrays.stream(PlaceSortBy.values())
                .filter(
                        v -> v.getColumn().equalsIgnoreCase(columnTrim)
                )
                .findFirst()
                .orElse(UPDATE_AT);
    }


    @Override
    public String toString() {
        return value;
    }

}
