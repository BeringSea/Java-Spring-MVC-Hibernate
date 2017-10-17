package com.luv2code.aopdemo.com.luv2code.aopdemo.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by David on 2017-10-17.
 */
@Component
public class TrafficFortuneService {

    public String getFortune(){

        // simulate a delay
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // return fortune
        return "Expect heavy traffic this morning";
    }

    public String getFortune(boolean tripWire) {
        if(tripWire){
            throw new RuntimeException("Major snow storm! Highway is closed!");
        }
        return getFortune();
    }
}
