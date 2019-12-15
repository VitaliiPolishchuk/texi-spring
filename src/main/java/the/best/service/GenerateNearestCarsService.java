package the.best.service;

import org.springframework.stereotype.Service;
import the.best.web.data.Location;
import the.best.web.data.OrderData;

import java.util.List;

@Service
public interface GenerateNearestCarsService {
    List<OrderData> generate(Location origin, Location destination);
}
