package the.best.service;


import org.springframework.stereotype.Service;
import the.best.web.data.Order;

import java.util.List;

@Service
public interface CarService {
    List<Order> getAllActiveCarByCarTypeId(int id);
}
