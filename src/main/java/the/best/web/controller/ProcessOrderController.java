package the.best.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import the.best.entity.Order;
import the.best.entity.User;
import the.best.service.OrderService;
import the.best.service.OrderServiceImpl;
import the.best.service.TransactionService;
import the.best.utils.ParamAttrConstant;
import the.best.utils.UrlConstant;
import the.best.web.data.Location;
import the.best.web.data.OrderData;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
@RequestMapping(path = UrlConstant.PROCESS_ORDER)
public class ProcessOrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    TransactionService transactionService;

    @GetMapping
    @Transactional
    public String processOrder(@RequestParam(ParamAttrConstant.CAR_ID) Integer carId, HttpSession session) {
        List<OrderData> orders = (List<OrderData>) session.getAttribute(ParamAttrConstant.ORDERS);

        OrderData desirableOrder = orderService.getCarById(orders, carId);
        desirableOrder.setDestination((Location) session.getAttribute(ParamAttrConstant.DESTINATION));
        desirableOrder.setOrigin((Location) session.getAttribute(ParamAttrConstant.ORIGIN));
        log.info("User is " + (User) session.getAttribute(ParamAttrConstant.USER));
        transactionService.processOrder(desirableOrder, (User) session.getAttribute(ParamAttrConstant.USER));
        return "redirect:/success";
    }
}
