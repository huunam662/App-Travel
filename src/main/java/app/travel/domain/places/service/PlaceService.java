package app.travel.domain.places.service;

import app.travel.advice.exception.templates.ErrorHolderException;
import app.travel.common.constant.Error;
import app.travel.domain.places.payload.request.PlaceFilterRequest;
import app.travel.domain.places.payload.response.PlaceResponse;
import app.travel.model.places.entity.PlaceEntity;
import app.travel.model.places.mapper.PlaceMapper;
import app.travel.model.places.repository.PlaceRepository;
import app.travel.shared.payload.response.FilterResponse;
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

    PlaceRepository placeRepository;

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

        FilterResponse<?> filterResponse = FilterResponse.<PlaceResponse>builder()
                .pageNumber(request.getPage())
                .pageSize(request.getPageSize())
                .build();

        Page<PlaceEntity> page = new Page<>(request.getPage(), request.getPageSize());




        return null;
    }
}
