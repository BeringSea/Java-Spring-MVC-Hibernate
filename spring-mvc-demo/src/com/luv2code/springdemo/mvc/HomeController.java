package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by David on 2017-08-07.
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String showPage(){
        return "main-menu";
    }
}
