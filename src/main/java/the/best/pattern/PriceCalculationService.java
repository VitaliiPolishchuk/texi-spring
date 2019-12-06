package the.best.pattern;


import the.best.entity.Discount;
import the.best.entity.User;
import the.best.web.data.Order;

public interface PriceCalculationService {
    void setNext(PriceCalculationService transactionHandler);
    void calculate(Order order, User user, Discount discount);
}
