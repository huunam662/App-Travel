package app.travel.util;

import app.travel.common.constant.SortDirection;
import app.travel.domain.places.payload.request.PlaceFilterRequest;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.ArrayList;
import java.util.List;

public class PlaceUtil {

    public static <T> QueryWrapper<T> queryFilter(QueryWrapper<T> queryWrapper, PlaceFilterRequest placeFilterRequest){

        if(queryWrapper == null) queryWrapper = new QueryWrapper<>();

        queryWrapper.isNotNull("id");

        String search = placeFilterRequest.getSearch();

        if(search != null && !search.isEmpty()){

            search = search.trim();

            if(search.contains(" ")){
                List<String> searchList = new ArrayList<>(List.of(search.split(" ")));
                queryWrapper.and(wrapper -> {
                    for(String val : searchList){

                        val = val.trim();

                        if(val.equals(","))
                            continue;

                        int valLength = val.length();

                        if(val.startsWith(","))
                            val = val.substring(1).trim();
                        else if(val.endsWith(","))
                            val = val.substring(0, valLength - 1).trim();

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

        boolean isAsc = placeFilterRequest.getSortType().equals(SortDirection.ASC);

        String column = placeFilterRequest.getSortBy().getColumn();

        queryWrapper.orderBy(true, isAsc, column);

        return queryWrapper;
    }

}
