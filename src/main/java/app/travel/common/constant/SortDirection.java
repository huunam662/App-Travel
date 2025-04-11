package app.travel.common.constant;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.core.convert.converter.Converter;
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
