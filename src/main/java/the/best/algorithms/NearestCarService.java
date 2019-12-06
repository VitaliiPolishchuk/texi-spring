package the.best.algorithms;

import the.best.web.data.Location;
import the.best.web.data.Order;

import java.util.List;

public interface NearestCarService {
    OrderAndDeltaTime findNearest(Location destination, List<Order> cars);
}
