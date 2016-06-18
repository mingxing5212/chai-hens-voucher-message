package me.mingxing5212.chaihens.voucher.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * HomeController
 *
 * @author Mingxing Li
 * @date 31/1/16
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String dashboard(){
        return "home/dashboard";
    }
}
