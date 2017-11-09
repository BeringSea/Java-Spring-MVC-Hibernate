package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by David on 2017-11-06.
 */
@Controller
public class DemoController {

    @GetMapping ("/")
    public String showHome(){
        return "home";
    }
}
