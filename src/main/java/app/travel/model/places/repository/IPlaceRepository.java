package app.travel.model.places.repository;

import app.travel.model.places.entity.PlaceEntity;

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

}
