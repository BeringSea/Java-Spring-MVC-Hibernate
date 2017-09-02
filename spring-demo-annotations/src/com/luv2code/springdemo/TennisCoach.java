package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by David on 2017-08-03.
 */
@Component
//@Scope("prototype") default scope is singleton
public class TennisCoach implements Coach {

//    @Qualifier("happyFortuneService")
//    @Autowired
    private FortuneService fortuneService;

    public TennisCoach() {
        System.out.println("Inside tennis coach default constructor");
    }


    // define my init method
//    @PostConstruct
//    public void doMyStartupStuff(){
//        System.out.println("Inside method - doMyStartUpStuff()");
//    }


    // define my destroy method
//    @PreDestroy
//    public void doMyCleanupStuff(){
//        System.out.println("Inside method - doMyCleanupStuff()");
//    }



    //    @Autowired
//    public TennisCoach(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }


//    // define setter method for autowireing
//    @Autowired
//    public void setFortuneService(FortuneService fortuneService) {
//        System.out.println("Inside tennis coach setter method - setFortuneService()");
//        this.fortuneService = fortuneService;
//    }

    // custom method for testing @Autowired annotation
//    @Autowired
//    public void doSomeFunnyStuff(FortuneService fortuneService){
//        System.out.println("Inside custom method - doSomeFunnyStuff");
//        this.fortuneService = fortuneService;
//    }

    @Override
    public String gedDailyWorkout() {

        return "Practice your backhand valley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
