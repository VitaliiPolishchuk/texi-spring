package the.best.service;


import org.springframework.stereotype.Service;
import the.best.entity.Discount;
import the.best.entity.User;
import the.best.web.data.OrderData;

import java.util.List;

@Service
public interface OrderService {
    void calculatePrice(List<OrderData> orders, User user, Discount discount);

    OrderData getCarById(List<OrderData> orders, int car_id);
}
