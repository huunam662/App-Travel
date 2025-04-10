package app.travel.util;

import app.travel.common.constant.SortDirection;
import app.travel.domain.places.payload.request.PlaceFilterRequest;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.ArrayList;
import java.util.List;

public class PlaceUtil {

    public static <T> QueryWrapper<T> queryFilter(QueryWrapper<T> queryWrapper, PlaceFilterRequest placeFilterRequest){

        if(queryWrapper == null) queryWrapper = new QueryWrapper<T>();

        queryWrapper.isNotNull("id");

        String search = placeFilterRequest.getSearch();

        if(search != null && !search.isEmpty()){
            if(search.contains(" ")){
                List<String> searchList = new ArrayList<>(List.of(search.split(" ")));
                queryWrapper.and(wrapper -> {
                    for(String val : searchList){

                        if(val.equals(","))
                            continue;

                        int valLength = val.length();

                        if(val.startsWith(","))
                            val = val.substring(1);
                        else if(val.endsWith(","))
                            val = val.substring(0, valLength - 1);

                        if(val.contains(",")){
                            String[] valArray = val.split(",");
                            val = valArray[0].trim();
                            searchList.add(valArray[1].trim());
                        }

                        wrapper.or().like("place_name", val);
                    }
                });
            }
            else{
                queryWrapper.like("place_name", search);
            }
        }

        boolean isAsc = SortDirection.fromValue(placeFilterRequest.getSortType()).equals(SortDirection.ASC);

        String column = placeFilterRequest.getSortBy().getColumn();

        queryWrapper.orderBy(true, isAsc, column);

        return queryWrapper;
    }

}
