package the.best.repository;

import org.springframework.data.repository.CrudRepository;
import the.best.entity.User;

public interface UserRepository extends CrudRepository<User, String> {
    User findByEmailAndEmailPassword(String email, String password);
}
