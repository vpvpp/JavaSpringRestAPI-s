package edu.ait.shoppingCart.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
public class HomePageController {

    @RequestMapping(value="/index")
    @ResponseBody
    public String indexPage() {
        return "";
    }
}


