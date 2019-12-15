package the.best.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import the.best.utils.ParamAttrConstant;
import the.best.utils.UrlConstant;
import the.best.entity.Discount;
import the.best.repository.DiscountRepository;
import the.best.web.data.Location;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping(path = UrlConstant.ORDER)
public class OrderController {

    @Autowired
    private DiscountRepository discountRepository;

    @GetMapping
    public String getOrderPage () {
        return "order";
    }

    @PostMapping
    public String processOrder(@RequestParam(ParamAttrConstant.ORIGIN) String origin,
                               @RequestParam(ParamAttrConstant.DESTINATION) String destionation,
                               @RequestParam(ParamAttrConstant.DISCOUNT) String discountId,
                               HttpSession session) {

        session.setAttribute(ParamAttrConstant.ORIGIN, new Location(origin));
        session.setAttribute(ParamAttrConstant.DESTINATION, new Location(destionation));
        log.info("Origin is " + session.getAttribute(ParamAttrConstant.ORIGIN));
        log.info("Destination is " + session.getAttribute(ParamAttrConstant.DESTINATION));

        Optional<Discount> discountOptional = discountRepository.findById(discountId);
        if (discountOptional.isPresent()){
            Discount discount = discountOptional.get();
            session.setAttribute(ParamAttrConstant.DISCOUNT, discount);
            log.info("Discount id " + discount);
        }

        return "redirect:/car-type-choose";
    }
}
