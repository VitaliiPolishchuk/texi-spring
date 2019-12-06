package the.best.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.Validator;
import the.best.config.UrlConfig;
import the.best.form.SingUpForm;
import the.best.entity.User;
import the.best.service.UserService;

import javax.annotation.Resource;
import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping(UrlConfig.SING_UP)
public class SingUpController {

    @Resource
    private UserService userService;

    @Resource(name = "singUpValidator")
    private Validator validator;

    @InitBinder
    private void initBinder(WebDataBinder binder){
        binder.setValidator(validator);
    }

    @GetMapping
    public String getLoginPage(Model model){
        model.addAttribute("singUpForm", new SingUpForm());
        return "singup";
    }

    @PostMapping
    public String registerUser(@Valid @ModelAttribute SingUpForm singUpForm, BindingResult error, Model model){
        log.info("Form {}", singUpForm);
        if(error.hasErrors()){
            return "singup";
        }
        User user = userService.singUpUser(singUpForm);
        if(user == null){
            error.rejectValue("email", "registration.email.exist");
            return "singup";
        }
        return "redirect:/order";
    }
}
