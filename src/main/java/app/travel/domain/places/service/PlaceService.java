package app.travel.domain.places.service;

import app.travel.advice.exception.templates.ErrorHolderException;
import app.travel.common.constant.Error;
import app.travel.converter.PlaceConverter;
import app.travel.domain.places.payload.request.PlaceFilterRequest;
import app.travel.domain.places.payload.response.PlaceResponse;
import app.travel.model.places.entity.PlaceEntity;
import app.travel.model.places.mapper.PlaceMapper;
import app.travel.model.places.repository.IPlaceRepository;
import app.travel.model.places.repository.PlaceRepository;
import app.travel.shared.payload.response.FilterResponse;
import app.travel.util.PlaceUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Slf4j(topic = "PLACE-SERVICE")
@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PlaceService implements IPlaceService{

    IPlaceRepository placeRepository;

    @Override
    public PlaceEntity getPlaceById(UUID id) {

        log.info("get place by id: {}", id);

        return placeRepository.findById(id).orElseThrow(
                () -> {
                    log.error("get place by id: {} failed", id);

                    return new ErrorHolderException(Error.RESOURCE_NOT_FOUND);
                }
        );
    }

    @Override
    public List<PlaceEntity> getAllPlaces() {

        return placeRepository.findAll();
    }

    @Override
    public FilterResponse<PlaceResponse> filterPlaces(PlaceFilterRequest request) {

        Page<PlaceEntity> page = new Page<>(request.getPage(), request.getPageSize());

        QueryWrapper<PlaceEntity> query = PlaceUtil.queryFilter(new QueryWrapper<>(), request);

        IPage<PlaceEntity> pageResult = placeRepository.selectPage(page, query);

        List<PlaceEntity> placeList = pageResult.getRecords();

        for(PlaceEntity place : placeList){
            if(place.getPlaceName().equalsIgnoreCase(request.getSearch())){
                if(placeList.remove(place)){
                    placeList.addFirst(place);
                    break;
                }
            }
        }

        List<PlaceResponse> results = PlaceConverter.INSTANCE.toPlaceResponseList(placeList);

        return FilterResponse.<PlaceResponse>builder()
                .pageNumber(pageResult.getCurrent())
                .totalPages(pageResult.getPages())
                .pageSize(pageResult.getSize())
                .totalElements(pageResult.getTotal())
                .results(results)
                .build();
    }
}
