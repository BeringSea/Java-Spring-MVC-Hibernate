package com.luv2code.springdemo;

/**
 * Created by David on 2017-08-06.
 */
public class SadFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Today is a sad day";
    }
}
