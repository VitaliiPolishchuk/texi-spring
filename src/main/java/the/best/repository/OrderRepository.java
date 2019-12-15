package the.best.repository;

import org.springframework.data.repository.CrudRepository;
import the.best.entity.Order;

public interface OrderRepository extends CrudRepository<Order, String> {
}
