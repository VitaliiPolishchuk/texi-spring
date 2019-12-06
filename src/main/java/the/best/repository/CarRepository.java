package the.best.repository;

import org.springframework.data.repository.CrudRepository;
import the.best.entity.Car;

public interface CarRepository extends CrudRepository<Car, Integer> {

}
