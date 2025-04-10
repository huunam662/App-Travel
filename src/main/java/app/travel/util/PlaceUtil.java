package app.travel.util;

import app.travel.domain.places.payload.request.PlaceFilterRequest;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.List;

public class PlaceUtil {

    public static <T> QueryWrapper<?> queryFilter(QueryWrapper<T> queryWrapper, PlaceFilterRequest placeFilterRequest){

        if(queryWrapper == null) queryWrapper = new QueryWrapper<T>().isNotNull("id");

        String search = placeFilterRequest.getSearch();

        if(search != null && !search.isEmpty()){
            if(search.contains(" ")){
                String[] searchArray = search.split(" ");
                for(String val : searchArray){
                    queryWrapper.or().like("name", val);
                }
            }
            else{
                queryWrapper.like("name", search);
            }
        }

        queryWrapper.orderBy()

    }

}
