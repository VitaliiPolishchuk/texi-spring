package the.best.repository;

import org.springframework.data.repository.CrudRepository;
import the.best.entity.CarActive;

public interface CarActiveRepository extends CrudRepository<CarActive, Integer> {

}
