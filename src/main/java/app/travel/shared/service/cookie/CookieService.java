package app.travel.shared.service.cookie;


import app.travel.advice.exception.templates.ErrorHolderException;
import app.travel.common.constant.other.CookieSameSite;
import app.travel.common.constant.other.Error;
import app.travel.shared.payload.internal.CookieInternal;
import app.travel.value.AppCoreValue;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CookieService implements ICookieService{

    AppCoreValue appCoreValue;

    @Override
    public Boolean sendCookieInclude(CookieInternal cookieTransfer, HttpServletResponse response) {

        if (cookieTransfer == null) return Boolean.TRUE;

        if(cookieTransfer.getKey() == null || cookieTransfer.getValue().isBlank())
            return Boolean.FALSE;

        String backendDomain = appCoreValue.getBackendDomain()
                .replaceFirst("https?://", "")
                .replaceAll(":\\d+", "")
                .toLowerCase();

        ResponseCookie responseCookie = ResponseCookie.from(cookieTransfer.getKey(), cookieTransfer.getValue())
                .path(cookieTransfer.getPath())
                .sameSite(CookieSameSite.STRICT.getPrettyName())
                .httpOnly(Boolean.TRUE)
                .secure(Boolean.TRUE)
                .domain(backendDomain)
                .maxAge(cookieTransfer.getMaxAge())
                .build();

        response.addHeader(HttpHeaders.SET_COOKIE, responseCookie.toString());

        return Boolean.TRUE;
    }

    @Override
    public Cookie getCookieFrom(HttpServletRequest request, String key, Boolean throwable) {

        Cookie[] cookies = request.getCookies();

        if(cookies == null && throwable)
            throw new ErrorHolderException(Error.COOKIE_NOT_EXISTED);

        Cookie cookie = Arrays.stream(cookies != null ? cookies : new Cookie[]{})
                .filter(
                        c -> c.getName().equals(key)
                ).findFirst().orElse(null);

        if(cookie == null && throwable)
            throw new ErrorHolderException(Error.COOKIE_NOT_EXISTED);

        return cookie;
    }

}
