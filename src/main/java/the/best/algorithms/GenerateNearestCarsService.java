package the.best.algorithms;

import org.springframework.stereotype.Service;
import the.best.web.data.Location;
import the.best.web.data.Order;

import java.util.List;

@Service
public interface GenerateNearestCarsService {
    List<Order> generate(Location origin, Location destination);
}
