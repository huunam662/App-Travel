package app.travel.config.web;

import app.travel.common.annotation.ExcludedContextPath;
import app.travel.common.constant.other.ContentDispositionType;
import app.travel.common.constant.other.SortDirection;
import app.travel.common.constant.other.UploadType;
import app.travel.common.constant.sort_by.LocationSortBy;
import app.travel.common.constant.sort_by.PlaceSortBy;
import app.travel.config.middleware.interceptor.MiddlewareInterceptorConfig;
import app.travel.value.AppCoreValue;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
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
                appCoreValue.getContextPath() + "/v3/api-docs/**",
                appCoreValue.getContextPath() + "/swagger-resources/**",
                appCoreValue.getContextPath() + "/webjars/**"
        );

        registry.addInterceptor(middlewareInterceptorConfig)
                .addPathPatterns("/**")
                .excludePathPatterns(excludePaths);

//        registry.addInterceptor(middlewareVoidResponseInterceptorConfig)
//                .addPathPatterns("/**")
//                .excludePathPatterns(excludePaths);
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {

        configurer.addPathPrefix(
                appCoreValue.getContextPath(),
                clazz -> clazz.isAnnotationPresent(RestController.class) &&
                        !clazz.isAnnotationPresent(ExcludedContextPath.class)
        );
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

        registry.addConverter(new Converter<String, LocationSortBy>() {

            @Override
            @NonNull
            public LocationSortBy convert(@NonNull String source) {

                return LocationSortBy.fromName(source);
            }
        });

        registry.addConverter(new Converter<String, UploadType>() {

            @Override
            @NonNull
            public UploadType convert(@NonNull String source) {

                return UploadType.fromType(source);
            }
        });

        registry.addConverter(new Converter<String, ContentDispositionType>() {

            @Override
            @NonNull
            public ContentDispositionType convert(@NonNull String source) {

                return ContentDispositionType.fromTypeResponse(source);
            }
        });
    }

}
