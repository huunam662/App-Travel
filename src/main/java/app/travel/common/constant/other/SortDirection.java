package app.travel.common.constant.other;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import java.util.Arrays;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum SortDirection {

    ASC("asc"),
    DESC("desc");

    String value;

    SortDirection(String value) {

        this.value = value;
    }

    public static final SortDirection DEFAULT = DESC;

    public static SortDirection fromValue(String value){

        if(value == null || value.isEmpty())
            return DESC;

        return Arrays.stream(SortDirection.values())
                .filter(
                        v -> v.getValue().equalsIgnoreCase(value)
                )
                .findFirst()
                .orElse(DESC);
    }

    @Override
    public String toString() {
        return value;
    }

}
