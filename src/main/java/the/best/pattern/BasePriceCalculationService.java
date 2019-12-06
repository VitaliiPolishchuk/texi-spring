package the.best.pattern;


import the.best.entity.Discount;
import the.best.entity.User;
import the.best.web.data.Order;

abstract public class BasePriceCalculationService implements PriceCalculationService{
    PriceCalculationService next;

    @Override
    public void setNext(PriceCalculationService transactionHandler){
        next = transactionHandler;
    }

    @Override
    abstract public void calculate(Order order, User user, Discount discount);
}
