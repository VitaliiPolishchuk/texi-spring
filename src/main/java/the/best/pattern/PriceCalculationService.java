package the.best.pattern;


import the.best.entity.Discount;
import the.best.entity.User;
import the.best.web.data.OrderData;

public interface PriceCalculationService {
    void setNext(PriceCalculationService transactionHandler);

    void calculate(OrderData order, User user, Discount discount);
}
