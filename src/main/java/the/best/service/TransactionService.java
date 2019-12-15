package the.best.service;

import org.springframework.stereotype.Service;
import the.best.entity.User;
import the.best.web.data.OrderData;

@Service
public interface TransactionService {
    void processOrder(OrderData order, User user);
}
