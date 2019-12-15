package the.best.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import the.best.utils.UrlConstant;

@Slf4j
@Controller
@RequestMapping(UrlConstant.SUCCESS)
public class SuccessController {
    @GetMapping
    public String getLoginPage() {
        return "success";
    }
}
