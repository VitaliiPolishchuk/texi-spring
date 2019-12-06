package the.best.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import the.best.entity.CarLocation;

import java.util.List;

public interface CarLocationRepository extends CrudRepository<CarLocation, Integer> {

    public static final String QUERY_ALL_WITH_LOCATION_ACTIVE_CAR_BY_TYPE_ID = "SELECT * FROM car_location " +
            "INNER JOIN car_active ON car_active.car_id = car_location.car_id " +
            "INNER JOIN car ON car_active.car_id = car.id " +
            "INNER JOIN car_type ON car.car_type_id = car_type.id " +
            "WHERE car_type.id = :car_type_id AND car.id IN ( " +
            "SELECT * FROM car_active " +
            ");";

    @Query(value = QUERY_ALL_WITH_LOCATION_ACTIVE_CAR_BY_TYPE_ID,
            nativeQuery = true)
    List<CarLocation> queryAllActiveCarByTypeId(@Param("car_type_id") Integer carTypeid);
}
