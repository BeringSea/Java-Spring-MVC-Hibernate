package com.luv2code.springdemo;

/**
 * Created by David on 2017-08-07.
 */
public class CrossfitCoach implements Coach {

    private FortuneService fortuneService;

    public CrossfitCoach() {
        System.out.println("Inside default constructor");
    }

    public CrossfitCoach(FortuneService fortuneService) {
        System.out.println("Inside my CrossFit constructor");
        this.fortuneService = fortuneService;
    }

    @Override
    public String gedDailyWorkout() {
        return "Give me 100 lus";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
