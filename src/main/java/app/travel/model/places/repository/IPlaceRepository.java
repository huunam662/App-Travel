package app.travel.model.places.repository;

import app.travel.model.places.entity.PlaceEntity;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IPlaceRepository {

    Optional<PlaceEntity> findById(UUID id);

    Optional<PlaceEntity> findByName(String name);

    List<PlaceEntity> findAll();

    List<PlaceEntity> findAllByIsForeign(Boolean isForeign);

    PlaceEntity insert(PlaceEntity place);

    PlaceEntity update(PlaceEntity place);

    void deleteById(UUID id);

    void delete(PlaceEntity place);

    IPage<PlaceEntity> selectPage(Page<PlaceEntity> page, QueryWrapper<PlaceEntity> queryWrapper);

}
