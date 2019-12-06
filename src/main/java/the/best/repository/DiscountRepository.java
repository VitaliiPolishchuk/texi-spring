package the.best.repository;

import org.springframework.data.repository.CrudRepository;
import the.best.entity.Discount;

public interface DiscountRepository extends CrudRepository<Discount, String> {

}
