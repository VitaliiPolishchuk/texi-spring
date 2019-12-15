package the.best.pattern;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import the.best.entity.Discount;
import the.best.entity.User;
import the.best.repository.UserRepository;
import the.best.service.UserService;
import the.best.web.data.OrderData;

@Slf4j
public class UserPointsPriceCalculationService extends BasePriceCalculationService {

    @Autowired
    UserRepository userRepository;

    public static final double DISCOUNT_PERCENT = 0.1;


    @Override
    public void calculate(OrderData order, User user, Discount discount) {
        int points = user.getUserPoints();
        if (isEmoughtPoints(points)) {
            double delta = order.getWholePrice() * DISCOUNT_PERCENT;
            order.setDiscountPrice(order.getDiscountPrice() - delta);
            order.setUserPoints(true);
        }

        if (next != null) {
            next.calculate(order, user, discount);
        }
    }

    private boolean isEmoughtPoints(int points) {
        return points >= UserService.POINTS_REQUIRE_TO_DISCOUNT;
    }
}
