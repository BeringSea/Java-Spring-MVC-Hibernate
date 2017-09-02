package com.luv2code.springdemo;

/**
 * Created by David on 2017-08-07.
 */
public class MyFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "My fortune service test";
    }
}
