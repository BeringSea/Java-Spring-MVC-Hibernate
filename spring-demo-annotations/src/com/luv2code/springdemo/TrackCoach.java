package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by David on 2017-08-03.
 */
@Component
public class TrackCoach implements Coach {
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    public TrackCoach() {
        System.out.println("Inside default constructor - TrackCoach");
    }

    // define my init methodt
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("Inside my method - doMyStartupStuff()");
    }

    // define my destroy method
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("Inside my method - doMyCleanupStuff()");
    }

    @Override
    public String gedDailyWorkout() {
        return "Run that track as hard as you can";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
