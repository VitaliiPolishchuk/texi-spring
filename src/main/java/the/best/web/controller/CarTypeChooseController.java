package the.best.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import the.best.service.GenerateNearestCarsService;
import the.best.utils.ParamAttrConstant;
import the.best.utils.UrlConstant;
import the.best.entity.Discount;
import the.best.entity.User;
import the.best.service.OrderService;
import the.best.web.data.Location;
import the.best.web.data.OrderData;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
@RequestMapping(UrlConstant.CAR_TYPE_CHOOSE)
public class CarTypeChooseController {

    @Autowired
    GenerateNearestCarsService generateNearestCarsService;

    @Autowired
    OrderService orderService;

    @GetMapping
    public String getOrderPage(HttpSession session) {
        Location origin = (Location) session.getAttribute(ParamAttrConstant.ORIGIN);
        Location destionation = (Location) session.getAttribute(ParamAttrConstant.DESTINATION);
        log.info("Origin is " + origin);
        log.info("Destination is " + destionation);

        List<OrderData> orders = generateNearestCarsService
                .generate(origin, destionation);
        orderService.calculatePrice(orders, (User) session.getAttribute(ParamAttrConstant.USER), (Discount) session.getAttribute(ParamAttrConstant.DISCOUNT));
        session.setAttribute(ParamAttrConstant.ORDERS, orders);

        return "car_type_choose";
    }
}
