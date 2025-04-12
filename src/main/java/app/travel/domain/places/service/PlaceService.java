package app.travel.domain.places.service;

import app.travel.advice.exception.templates.ErrorHolderException;
import app.travel.common.constant.Error;
import app.travel.converter.PlaceConverter;
import app.travel.domain.places.payload.request.ChangeIsForeignRequest;
import app.travel.domain.places.payload.request.EditPlaceRequest;
import app.travel.domain.places.payload.request.NewPlaceRequest;
import app.travel.domain.places.payload.request.PlaceFilterRequest;
import app.travel.domain.places.payload.response.PlaceResponse;
import app.travel.model.places.entity.PlaceEntity;
import app.travel.model.places.mapper.PlaceMapper;
import app.travel.model.places.repository.IPlaceRepository;
import app.travel.model.places.repository.PlaceRepository;
import app.travel.shared.payload.response.FilterResponse;
import app.travel.shared.payload.response.KeyResourceResponse;
import app.travel.util.PlaceUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<PlaceEntity> getListPlaces() {

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
                .totalElements((long) results.size())
                .results(results)
                .build();
    }

    @Override
    @Transactional
    public KeyResourceResponse<?> createPlace(NewPlaceRequest request) {

        checkExistsByPlaceName(request.getPlaceName(), true);

        PlaceEntity place = PlaceConverter.INSTANCE.toPlaceEntity(request);

        place = placeRepository.insert(place);

        return KeyResourceResponse.builder()
                .key(place.getId())
                .build();
    }

    @Override
    @Transactional
    public KeyResourceResponse<?> updatePlace(EditPlaceRequest request) {

        PlaceEntity place = getPlaceById(request.getId());

        checkExistsByPlaceNameAndNotId(place.getId(), request.getPlaceName(), true);

        PlaceConverter.INSTANCE.flowToPlaceEntity(place, request);

        place = placeRepository.update(place);

        return KeyResourceResponse.builder()
                .key(place.getId())
                .build();
    }

    @Override
    @Transactional
    public KeyResourceResponse<?> changePlaceIsForeign(ChangeIsForeignRequest request) {

        PlaceEntity place = getPlaceById(request.getId());

        place.setIsForeign(request.getIsForeign());

        place = placeRepository.update(place);

        return KeyResourceResponse.builder()
                .key(place.getId())
                .build();
    }

    @Override
    @Transactional
    public void deletePlaceById(UUID id) {

        PlaceEntity place = getPlaceById(id);

        placeRepository.delete(place);
    }

    @Override
    @Transactional
    public void deletePlace(PlaceEntity placeEntity) {

        placeRepository.delete(placeEntity);
    }

    @Override
    public Boolean checkExistsByPlaceName(String placeName, Boolean throwable) {

        Boolean isExists = placeRepository.existsByPlaceName(placeName);

        if(isExists && throwable)
            throw new ErrorHolderException(Error.RESOURCE_EXISTED);

        return isExists;
    }

    @Override
    public Boolean checkExistsByPlaceNameAndNotId(UUID id, String placeName, Boolean throwable) {

        Boolean isExists = placeRepository.existsByPlaceNameAndNotId(placeName, id);

        if(isExists && throwable)
            throw new ErrorHolderException(Error.RESOURCE_EXISTED);

        return isExists;
    }
}
