package the.best.pattern;


import the.best.entity.Discount;
import the.best.entity.User;
import the.best.web.data.OrderData;

abstract public class BasePriceCalculationService implements PriceCalculationService {
    PriceCalculationService next;

    @Override
    public void setNext(PriceCalculationService transactionHandler) {
        next = transactionHandler;
    }

    @Override
    abstract public void calculate(OrderData order, User user, Discount discount);
}
