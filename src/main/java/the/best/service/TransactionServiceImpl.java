package the.best.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import the.best.entity.Car;
import the.best.entity.Order;
import the.best.entity.User;
import the.best.repository.CarRepository;
import the.best.repository.OrderRepository;
import the.best.web.data.OrderData;

import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private OrderService orderService;


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public void processOrder(OrderData orderData, User user) {
        log.info("Executing process order transaction with order " + orderData);
        Order order = new Order();
        order.setCar(orderData.getCar());
        order.setDestinationId(orderData.getDestination().getLocationName());
        order.setOriginId(orderData.getOrigin().getLocationName());
        order.setPrice(orderData.getDiscountPrice());
        order.setUser(user);
        orderRepository.save(order);

        Car car = orderData.getCar();
        car.setIsActive(false);
        carRepository.save(car);

        userService.updateUserPoints(user, (int) orderData.getDiscountPrice(), orderData.isUserPoints());

        log.info("Executed process order transaction with order " + order);
    }


}
