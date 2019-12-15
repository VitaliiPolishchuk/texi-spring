package the.best.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import the.best.entity.Car;
import the.best.repository.CarRepository;
import the.best.web.data.Location;
import the.best.web.data.OrderData;
import the.best.web.data.builder.OrderBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<OrderData> getAllActiveCarByCarTypeId(int id) {
        List<Car> cars = carRepository.queryAllActiveCarByTypeId(id);
        List<OrderData> res = new ArrayList<>();
        for (Car car : cars) {
            Location carLocation = new Location(car.getLocationId());
            OrderData order = new OrderData(new OrderBuilder()
                    .setCar(car)
                    .setCarLocation(carLocation));

            res.add(order);
        }
        return res;
    }
}
