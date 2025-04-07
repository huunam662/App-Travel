package app.travel.shared.payload.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FilterResponse<T> {

    Integer pageNumber;

    Integer pageSize;

    Integer totalElements;

    Boolean hasPreviousPage;

    Boolean hasNextPage;

    List<T> results;

    public void hasNextOrPreviousPage() {

        hasPreviousPage = pageNumber > 1;
        hasNextPage = pageNumber < pageSize;
    }
}
