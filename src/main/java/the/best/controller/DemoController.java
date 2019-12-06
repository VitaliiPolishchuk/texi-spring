package the.best.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import the.best.entity.Discount;
import the.best.repository.DiscountRepository;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class DemoController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private DiscountRepository discountRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody
    String addNewUser (@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Discount d = new Discount();
        d.setId("demo");
        d.setPercent(0.15);
        discountRepository.save(d);
        return "Saved";
    }

    @GetMapping(path="/all")
    public String getAllUsers(Model model) {
        return "demo";
    }
}