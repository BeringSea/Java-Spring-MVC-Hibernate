package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

/**
 * Created by David on 2017-08-06.
 */
@Component
public class RESTFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "This is RESTFortuneService";
    }
}
