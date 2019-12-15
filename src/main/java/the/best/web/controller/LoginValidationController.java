package the.best.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import the.best.utils.ParamAttrConstant;
import the.best.utils.UrlConstant;
import the.best.entity.User;
import the.best.service.UserService;
import the.best.web.data.AjaxLoginResponse;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequestMapping(path = UrlConstant.LOGIN_VALIDATION)
public class LoginValidationController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseBody
    public AjaxLoginResponse login(@RequestParam(name = "email") String email,
                                   @RequestParam String password,
                                   HttpSession session) {
        log.info("Try to email : {}, password : {} ", email, password);
        AjaxLoginResponse ajaxResponse = new AjaxLoginResponse();

        User user = new User();
        user.setEmail(email);
        user.setEmailPassword(password);

        user = userService.validate(user);
        log.info(user.getEmail());
        if (user != null) {
            log.info("user=" + user);
            session.setAttribute(ParamAttrConstant.USER, user);
            ajaxResponse.setUrl("/order");
            ajaxResponse.setSuccess(true);
            return ajaxResponse;
        }

        ajaxResponse.setMessage("Invalid credential! Please, try again.");
        return ajaxResponse;
    }
}
