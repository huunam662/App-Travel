package app.travel.config.web;

import app.travel.common.constant.SortDirection;
import app.travel.common.constant.sort_by.PlaceSortBy;
import app.travel.config.middleware.interceptor.MiddlewareInterceptorConfig;
import app.travel.config.middleware.interceptor.MiddlewareVoidResponseInterceptorConfig;
import app.travel.value.AppCoreValue;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.List;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WebConfig implements WebMvcConfigurer {

    AppCoreValue appCoreValue;

    MiddlewareInterceptorConfig middlewareInterceptorConfig;

//    MiddlewareVoidResponseInterceptorConfig middlewareVoidResponseInterceptorConfig;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        List<String> excludePaths = List.of(
                appCoreValue.getPrefixPath() + "/v3/api-docs/**",
                appCoreValue.getPrefixPath() + "/swagger-resources/**",
                appCoreValue.getPrefixPath() + "/webjars/**"
        );

        registry.addInterceptor(middlewareInterceptorConfig)
                .addPathPatterns("/**")
                .excludePathPatterns(excludePaths);

//        registry.addInterceptor(middlewareVoidResponseInterceptorConfig)
//                .addPathPatterns("/**")
//                .excludePathPatterns(excludePaths);
    }


    @Override
    public void addFormatters(FormatterRegistry registry) {

        registry.addConverter(new Converter<String, PlaceSortBy>() {

            @Override
            @NonNull
            public PlaceSortBy convert(@NonNull String source) {
                return PlaceSortBy.fromValue(source);
            }
        });

        registry.addConverter(new Converter<String, SortDirection>() {

            @Override
            @NonNull
            public SortDirection convert(@NonNull String source) {
                return SortDirection.fromValue(source);
            }
        });
    }


}
