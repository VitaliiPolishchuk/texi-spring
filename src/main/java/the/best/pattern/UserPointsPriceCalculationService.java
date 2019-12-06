package the.best.pattern;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import the.best.entity.Discount;
import the.best.entity.User;
import the.best.repository.UserPointsRepository;
import the.best.service.UserService;
import the.best.web.data.Order;

@Slf4j
public class UserPointsPriceCalculationService extends BasePriceCalculationService {

    @Autowired
    UserPointsRepository userPointsRepository;

    public static final double DISCOUNT_PERCENT = 0.1;


    @Override
    public void calculate(Order order, User user, Discount discount) {
//        log.info("user=" + user.getEmail());
//        UserPoints userPoints = userPointsRepository.findByUserEmail(user.getEmail());
//        if(userPoints != null) {
//            int points = userPoints.getAmount();
//            ;
//
//            if (isEmoughtPoints(points)) {
//                double delta = order.getWholePrice() * DISCOUNT_PERCENT;
//                order.setDiscountPrice(order.getDiscountPrice() - delta);
//                order.setUserPoints(true);
//            }
//        }

        if(next != null) {
            next.calculate(order, user, discount);
        }
    }

    private boolean isEmoughtPoints(int points){
        return points >= UserService.POINTS_REQUIRE_TO_DISCOUNT;
    }
}
