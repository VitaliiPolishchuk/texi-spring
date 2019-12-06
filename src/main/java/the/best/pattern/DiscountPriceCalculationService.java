package the.best.pattern;


import the.best.entity.Discount;
import the.best.entity.User;
import the.best.web.data.Order;

public class DiscountPriceCalculationService extends BasePriceCalculationService {

    @Override
    public void calculate(Order order, User user, Discount discount) {
        if(discount != null) {
            double delta = order.getWholePrice() * discount.getPercent();
            order.setDiscountPrice(order.getDiscountPrice() - delta);
            order.setDiscount(true);
        }
        if(next != null) {
            next.calculate(order, user, discount);
        }
    }
}
