package the.best.service;

import the.best.web.data.Location;
import the.best.web.data.OrderData;

import java.util.List;
import java.util.PriorityQueue;

public class NearestCarServiceImpl implements NearestCarService {

    private TimeCalculationService timeCalculationService = new TimeCalculationServiceImpl();
    private static final String PLACE_ID_POINTER = "place_id:";

    @Override
    public OrderAndDeltaTime findNearest(Location destination, List<OrderData> orders) {
        if (orders.size() == 0) {
            return null;
        }
        PriorityQueue<OrderAndDeltaTime> orderAndDeltaTimePriorityQueue = new PriorityQueue<>();

        for (int i = 0; i < orders.size(); ++i) {

            OrderData car = orders.get(i);
            Location carLocation = new Location(car.getCarLocation().getLocationName());
            carLocation.setLocationName(PLACE_ID_POINTER + carLocation.getLocationName());
            int delta = (int) timeCalculationService.calculateTime(carLocation, destination);

            OrderAndDeltaTime orderAndDeltaTime =
                    new OrderAndDeltaTime(car, delta);

            orderAndDeltaTimePriorityQueue.add(orderAndDeltaTime);

            if (i > 0) {
                orderAndDeltaTimePriorityQueue.poll();
            }
        }

        return orderAndDeltaTimePriorityQueue.poll();
    }
}


