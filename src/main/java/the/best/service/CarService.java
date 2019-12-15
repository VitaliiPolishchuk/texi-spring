package the.best.service;


import org.springframework.stereotype.Service;
import the.best.web.data.OrderData;

import java.util.List;

@Service
public interface CarService {
    List<OrderData> getAllActiveCarByCarTypeId(int id);
}
