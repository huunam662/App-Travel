package app.travel.model.places.repository;


import app.travel.model.places.entity.PlaceEntity;
import app.travel.model.places.mapper.PlaceMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PlaceRepository implements IPlaceRepository{

    PlaceMapper placeMapper;

    @Override
    public Optional<PlaceEntity> findById(UUID id) {

        return Optional.ofNullable(placeMapper.selectById(id));
    }

    @Override
    public Optional<PlaceEntity> findByName(String name) {

        return placeMapper.selectByName(name);
    }

    @Override
    public List<PlaceEntity> findAll() {

        return placeMapper.selectList(new QueryWrapper<>());
    }

    @Override
    public List<PlaceEntity> findAllByIsForeign(Boolean isForeign) {

        return placeMapper.selectListByIsForeign(isForeign);
    }

    @Override
    @Transactional
    public PlaceEntity insert(PlaceEntity place) {

        placeMapper.insert(place);

        return place;
    }

    @Override
    @Transactional
    public PlaceEntity update(PlaceEntity place) {

        placeMapper.updateById(place);

        return place;
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {

        placeMapper.deleteById(id);
    }

    @Override
    @Transactional
    public void delete(PlaceEntity place) {

        placeMapper.deleteById(place);
    }
}
