package the.best.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import the.best.utils.UrlConstant;

@Slf4j
@Controller
@RequestMapping(UrlConstant.LOGIN)
public class LoginController {


    @GetMapping
    public String getLoginPage() {
        return "login";
    }
}
