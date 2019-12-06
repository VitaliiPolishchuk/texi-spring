package the.best.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import the.best.entity.Discount;
import the.best.entity.User;
import the.best.pattern.PriceCalculationChainBuilder;
import the.best.pattern.PriceCalculationService;
import the.best.web.data.Order;

import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    PriceCalculationChainBuilder priceCalculationChainBuilder;

    @Override
    public void calculatePrice(List<Order> orders, User user, Discount discount) {
        PriceCalculationService priceCalculationService = priceCalculationChainBuilder.buildStandart();
        for(Order order : orders){
            priceCalculationService.calculate(order, user, discount);
        }
    }

    @Override
    public Order getCarById(List<Order> orders, int car_id) {
        Order desirableOrder = null;
        for(Order order : orders){
            if(order.getCar().getId() == car_id){
                desirableOrder = order;
            }
        }
        return desirableOrder;
    }
}
