package app.travel.advice.response;

import app.travel.common.annotation.DefaultMessage;
import app.travel.common.constant.ContentDispositionType;
import app.travel.domain.resource.payload.response.ResourceFileResponse;
import app.travel.shared.payload.response.FilterResponse;
import app.travel.shared.payload.response.ResourceResponse;
import app.travel.shared.payload.response.ResultApiResponse;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;


@Slf4j(topic = "GLOBAL-OBJECT-RESPONSE-WRAPPER")
@RestControllerAdvice
public class GlobalObjectResponseWrapper implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(
            MethodParameter returnType,
            Class<? extends HttpMessageConverter<?>> converterType
    ) {

        // (1) -> Nhận biết hướng đi của request và vị trí của handler response
        Class<?> declaringClass = returnType.getDeclaringClass();
        String packageName = declaringClass.getPackageName();
        Class<?> objectReturnType = returnType.getParameterType();
        // -> end (1)

        log.info("Package: {}", packageName);
        log.info("declaringClass: {}", declaringClass);

        return !packageName.contains("springdoc") &&
                !packageName.contains("swagger") &&
                (
                    declaringClass.getAnnotation(RestController.class) != null ||
                    objectReturnType.equals(ResultApiResponse.ErrorResponse.class)
                );
    }

    @Override
    @SneakyThrows
    public Object beforeBodyWrite(
            Object body,
            MethodParameter returnType,
            MediaType selectedContentType,
            Class<? extends HttpMessageConverter<?>> selectedConverterType,
            ServerHttpRequest request,
            ServerHttpResponse response
    ) {

        if(body instanceof ResultApiResponse.ErrorResponse errorResponse){

            log.error("Error response with message: {}", errorResponse.getMessage());

            response.setStatusCode(HttpStatus.valueOf(errorResponse.getCode()));

            errorResponse.setSuccess(Boolean.FALSE);
            errorResponse.setPath(request.getURI().getPath());

            return errorResponse;
        }

        if(body instanceof ResourceFileResponse resourceFileResponse){

            Resource resource = resourceFileResponse.getResource();
            ContentDispositionType contentDispositionType = resourceFileResponse.getContentDisposition();

            HttpHeaders httpHeaders = response.getHeaders();

            httpHeaders.setContentLength(resourceFileResponse.getContentLength());
            httpHeaders.setContentType(resourceFileResponse.getMediaType());
            httpHeaders.setContentDisposition(
                    ContentDisposition.builder(contentDispositionType.name())
                            .filename(resource.getFilename(), StandardCharsets.UTF_8)
                            .build()
            );

            return resource.getInputStream();
        }

//        Method method = returnType.getMethod();

//        ResponseStatus responseStatus = method.getAnnotation(ResponseStatus.class);
//
//        HttpStatus statusResponse = responseStatus != null ? responseStatus.value() : AppUtil.statusOfMethod(request.getMethod());
//
//        response.setStatusCode(statusResponse);

        DefaultMessage defaultMessage = returnType.getMethodAnnotation(DefaultMessage.class);

        HttpStatus statusResponse = HttpStatus.OK;

        response.setStatusCode(statusResponse);

        log.info("Result api response with message: {}", defaultMessage);

        if(body instanceof FilterResponse<?> filterResponse)
            filterResponse.hasNextOrPreviousPage();

        return ResultApiResponse.builder()
                .success(true)
                .message(defaultMessage != null ? defaultMessage.message() : "")
                .status(statusResponse.getReasonPhrase())
                .code(statusResponse.value())
                .path(request.getURI().getPath())
                .data(
                        ResourceResponse.builder()
                                .resource(body)
                                .build()
                ).build();
    }

}