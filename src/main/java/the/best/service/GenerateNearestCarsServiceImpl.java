package the.best.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import the.best.entity.CarType;
import the.best.repository.CarTypeRepository;
import the.best.web.data.Location;
import the.best.web.data.OrderData;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class GenerateNearestCarsServiceImpl implements GenerateNearestCarsService {

    @Autowired
    private CarTypeRepository carTypeRepository;
    @Autowired
    private CarService carService;
    NearestCarService nearestCarService = new NearestCarServiceImpl();
    TimeCalculationService timeCalculationService = new TimeCalculationServiceImpl();

    @Override
    public List<OrderData> generate(Location origin, Location destination) {
        List<OrderData> res = new ArrayList<>();
        List<CarType> carTypes = new ArrayList<>();
        carTypeRepository.findAll().forEach(carTypes::add);
        long timeToReachFromOriginToDestination = timeCalculationService.calculateTime(origin, destination);
        log.info("timeToReachFromOriginToDestination=" + timeToReachFromOriginToDestination);
        for (CarType carType : carTypes) {
            List<OrderData> carsWithLocationIdByCarType = carService.getAllActiveCarByCarTypeId(carType.getId());
            OrderAndDeltaTime orderAndDeltaTime = nearestCarService.findNearest(origin, carsWithLocationIdByCarType);
            if (orderAndDeltaTime != null) {
                OrderData order = orderAndDeltaTime.getOrder();
                order.setTimeToReachOrigin(orderAndDeltaTime.getDelta());
                order.setCarType(carType);
                order.setTimeToReachDestination((int) (timeToReachFromOriginToDestination + orderAndDeltaTime.getDelta()));
                res.add(order);
            }
        }

        return res;
    }
}
