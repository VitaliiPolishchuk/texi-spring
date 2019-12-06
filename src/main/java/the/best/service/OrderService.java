package the.best.service;


import org.springframework.stereotype.Service;
import the.best.entity.Discount;
import the.best.entity.User;
import the.best.web.data.Order;

import java.util.List;

@Service
public interface OrderService {
    void calculatePrice(List<Order> orders, User user, Discount discount);
    Order getCarById(List<Order> orders, int car_id);
}
