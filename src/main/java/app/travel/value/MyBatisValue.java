package app.travel.value;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MyBatisValue {

    @Value("${mybatis-plus.mapper-locations}")
    String mapperLocations;

    @Value("${mybatis-plus.configuration.map-underscore-to-camel-case}")
    Boolean mapUnderscoreToCamelCase;

    @Value("${mybatis-plus.configuration.cache-enabled}")
    Boolean cacheEnabled;

}
