package app.travel.utils;

import jakarta.servlet.http.HttpServletRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class HttpUtils {


    public static String getRequestIP(HttpServletRequest request) {

        String ip = request.getHeader("X-FORWARDED-FOR");

        if (ip == null || ip.isEmpty())
            ip = request.getRemoteAddr();

        return ip;
    }
}
