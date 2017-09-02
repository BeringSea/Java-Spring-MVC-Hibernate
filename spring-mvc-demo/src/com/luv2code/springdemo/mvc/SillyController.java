package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by David on 2017-08-08.
 */
@Controller
public class SillyController {
    @RequestMapping("/showForm")
    public String displayTheForm(){
        return "silly";
    }
}
