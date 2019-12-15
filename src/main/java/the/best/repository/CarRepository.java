package the.best.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import the.best.entity.Car;
import the.best.entity.User;

import java.util.List;


public interface CarRepository extends CrudRepository<Car, Integer> {
    @Query(
            value = "SELECT * FROM car WHERE is_active = 1 AND car_type_id = :type_id",
            nativeQuery = true)
    List<Car> queryAllActiveCarByTypeId(@Param("type_id") Integer id);
}
