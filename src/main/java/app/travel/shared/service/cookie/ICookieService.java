package app.travel.shared.service.cookie;

import app.travel.shared.payload.internal.CookieInternal;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ICookieService {

    Boolean sendCookieInclude(CookieInternal cookieTransfer, HttpServletResponse response);

    Cookie getCookieFrom(HttpServletRequest request, String key, Boolean throwable);

}
