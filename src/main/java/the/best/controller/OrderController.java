package the.best.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import the.best.config.ParamAttrConfig;
import the.best.config.UrlConfig;
import the.best.entity.Discount;
import the.best.repository.DiscountRepository;
import the.best.web.data.Location;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping(path= UrlConfig.ORDER)
public class OrderController {

    @Autowired
    private DiscountRepository discountRepository;

    @GetMapping
    public String getOrderPage () {
        return "order";
    }

    @PostMapping
    public String processOrder(@RequestParam(ParamAttrConfig.ORIGIN) String origin,
                               @RequestParam(ParamAttrConfig.DESTINATION) String destionation,
                               @RequestParam(ParamAttrConfig.DISCOUNT) String discountId,
                               HttpSession session) {

        session.setAttribute(ParamAttrConfig.ORIGIN, new Location(origin));
        session.setAttribute(ParamAttrConfig.DESTINATION, new Location(destionation));
        log.info("Origin is " + session.getAttribute(ParamAttrConfig.ORIGIN));
        log.info("Destination is " + session.getAttribute(ParamAttrConfig.DESTINATION));

        Optional<Discount> discountOptional = discountRepository.findById(discountId);
        if (discountOptional.isPresent()){
            Discount discount = discountOptional.get();
            session.setAttribute(ParamAttrConfig.DISCOUNT, discount);
            log.info("Discount id " + discount);
        }

        return "redirect:/car-type-choose";
    }
}
