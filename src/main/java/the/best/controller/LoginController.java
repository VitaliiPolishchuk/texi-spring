package the.best.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import the.best.config.UrlConfig;
import the.best.repository.CarActiveRepository;

@Slf4j
@Controller
@RequestMapping(UrlConfig.LOGIN)
public class LoginController {

    @Autowired
    CarActiveRepository carActiveRepository;

    @GetMapping
    public String getLoginPage(){
//        Iterator<CarActive> carIterator = carActiveRepository.findAll().iterator();
//        while(carIterator.hasNext()){
//            CarActive carActive = carIterator.next();
//            log.info("car " + carActive.getCarId());
//        }
        return "login";
    }
}
