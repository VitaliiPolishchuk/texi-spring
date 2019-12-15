package the.best.service;

import the.best.web.data.Location;
import the.best.web.data.OrderData;

import java.util.List;

public interface NearestCarService {
    OrderAndDeltaTime findNearest(Location destination, List<OrderData> cars);
}
