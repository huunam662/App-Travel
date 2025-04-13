package app.travel.common.constant.sort_by;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum LocationSortBy {

    NAME("name"),
    FULL_NAME("full_name"),
    CODE_NAME("code_name");

    String name;

    LocationSortBy(String name) {
        this.name = name;
    }

    public static final LocationSortBy DEFAULT = LocationSortBy.NAME;

    public static LocationSortBy fromName(String name) {

        if(name == null || name.isEmpty())
            return NAME;

        return Arrays.stream(LocationSortBy.values()).filter(
                p -> p.getName().equalsIgnoreCase(name)
        ).findFirst().orElse(NAME);
    }


    @Override
    public String toString() {

        return name;
    }
}
