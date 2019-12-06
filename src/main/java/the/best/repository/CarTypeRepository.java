package the.best.repository;

import org.springframework.data.repository.CrudRepository;
import the.best.entity.CarType;

public interface CarTypeRepository extends CrudRepository<CarType, Integer> {
}
