package the.best.repository;

import org.springframework.data.repository.CrudRepository;
import the.best.entity.UserPoints;

public interface UserPointsRepository extends CrudRepository<UserPoints, String> {
    UserPoints findByUserEmail(String email);
}
