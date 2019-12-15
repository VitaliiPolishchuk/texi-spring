package the.best.pattern;


import the.best.entity.Discount;
import the.best.entity.User;
import the.best.web.data.OrderData;

public class KmPriceCalculationService extends BasePriceCalculationService {
    @Override
    public void calculate(OrderData order, User user, Discount discount) {
        double money = (order.getTimeToReachDestination() - order.getTimeToReachOrigin()) / 60;
        order.setDiscountPrice(order.getDiscountPrice() + money);
        order.setWholePrice(order.getWholePrice() + money);

        if (next != null) {
            next.calculate(order, user, discount);
        }
    }
}
