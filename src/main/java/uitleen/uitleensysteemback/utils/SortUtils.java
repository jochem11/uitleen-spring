package uitleen.uitleensysteemback.utils;

import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
public class SortUtils {
    public static <T> Sort getPagedSort(Class<T> modelClass, String sortBy, String sortDir) {
        Set<String> validFields = Arrays.stream(modelClass.getDeclaredFields())
                .map(Field::getName)
                .collect(Collectors.toSet());

        if (!validFields.contains(sortBy)) {
            sortBy = "id";
        }

        boolean isAscending = sortDir == null || sortDir.equalsIgnoreCase("asc");
        boolean isDescending = sortDir != null && sortDir.equalsIgnoreCase("desc");

        if (!isAscending && !isDescending) {
            isAscending = true;
        }

        return isAscending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
    }
}
