package app.travel.utils;

import lombok.experimental.UtilityClass;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

@UtilityClass
public class AppUtils {

    public static HttpStatus statusOfMethod(HttpMethod method){

        if(method.equals(HttpMethod.POST))
            return HttpStatus.CREATED;
        else if(method.equals(HttpMethod.PUT) || method.equals(HttpMethod.PATCH))
            return HttpStatus.ACCEPTED;
        else if(method.equals(HttpMethod.DELETE))
            return HttpStatus.NO_CONTENT;
        else return HttpStatus.OK;
    }

}
