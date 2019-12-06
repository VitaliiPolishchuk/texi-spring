package the.best.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import the.best.entity.Car;
import the.best.entity.CarLocation;
import the.best.repository.CarLocationRepository;
import the.best.repository.CarRepository;
import the.best.web.data.Location;
import the.best.web.data.Order;
import the.best.web.data.builder.OrderBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarLocationRepository carLocationRepository;
    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Order> getAllActiveCarByCarTypeId(int id) {
        List<CarLocation> carsWithLocation = carLocationRepository.queryAllActiveCarByTypeId(id);
        List<Order> res = new ArrayList<>();
        for(CarLocation carLocation : carsWithLocation){
            Car car = carRepository.findById(carLocation.getCarId()).get();
            Location origin = new Location(carLocation.getLocationId());
            Order order = new Order(new OrderBuilder()
                    .setCar(car)
                    .setOrigin(origin));

            res.add(order);
        }
        return res;
    }
}
