package the.best.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import the.best.web.form.SingUpForm;
import the.best.entity.User;
import the.best.repository.UserRepository;

import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    private final static double PERCENT_PRICE_TO_POINTS = 0.1;

    @Override
    public User validate(User user) {
        log.info(String.valueOf(userRepository.getClass()));
        return userRepository.findByEmailAndEmailPassword(user.getEmail(), user.getEmailPassword());
    }

    @Override
    public User singUpUser(SingUpForm singUpForm) {
        log.info(singUpForm.getEmail());
        Optional<User> optionalUser = userRepository.findById(singUpForm.getEmail());

        if (optionalUser.isPresent()) {
            return null;
        }
        User user = new User();
        user.setEmail(singUpForm.getEmail());
        user.setFirstName(singUpForm.getFirst_name());
        user.setLastName(singUpForm.getLast_name());
        user.setEmailPassword(singUpForm.getPassword());
        return userRepository.save(user);
    }

    @Override
    public void updateUserPoints(User user, int price, boolean isUsedDiscount) {
        int currentPoints = user.getUserPoints();
        log.info(user.getEmail());
        log.info(user.getEmailPassword());
        log.info(user.getFirstName());
        log.info(user.getLastName());
        log.info(Integer.toString(user.getUserPoints()));
        if (isUsedDiscount) {
            currentPoints -= POINTS_REQUIRE_TO_DISCOUNT;
        }
        user.setUserPoints(calculatePoints(currentPoints, price));
        log.info(String.valueOf(userRepository.getClass()));
        userRepository.save(
                user);
    }


    private int calculatePoints(int curPoints, int price) {
        return (int) (curPoints + price * PERCENT_PRICE_TO_POINTS);
    }

}
