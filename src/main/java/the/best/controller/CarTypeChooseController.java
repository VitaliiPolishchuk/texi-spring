package the.best.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import the.best.algorithms.GenerateNearestCarsService;
import the.best.config.ParamAttrConfig;
import the.best.config.UrlConfig;
import the.best.entity.Discount;
import the.best.entity.User;
import the.best.service.OrderService;
import the.best.web.data.Location;
import the.best.web.data.Order;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
@RequestMapping(UrlConfig.CAR_TYPE_CHOOSE)
public class CarTypeChooseController {

    @Autowired
    GenerateNearestCarsService generateNearestCarsService;

    @Autowired
    OrderService orderService;

    @GetMapping
    public String getOrderPage (HttpSession session) {
        Location origin = (Location)session.getAttribute(ParamAttrConfig.ORIGIN);
        Location destionation = (Location)session.getAttribute(ParamAttrConfig.DESTINATION);
        log.info("Origin is " + origin);
        log.info("Destination is " + destionation);

        List<Order> orders = generateNearestCarsService
                .generate(origin, destionation);
        orderService.calculatePrice(orders, (User) session.getAttribute(ParamAttrConfig.USER), (Discount)session.getAttribute(ParamAttrConfig.DISCOUNT));
        session.setAttribute(ParamAttrConfig.ORDERS, orders);

        return "car_type_choose";
    }
}
