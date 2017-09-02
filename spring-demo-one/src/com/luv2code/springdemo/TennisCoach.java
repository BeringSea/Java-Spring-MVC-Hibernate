package com.luv2code.springdemo;


/**
 * Created by David on 2017-08-02.
 */
public class TennisCoach implements Coach {

    private FortuneService fortuneService;

    public TennisCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Play tennis as Roger Federer";
    }

    @Override
    public String getDailyFortune() {
        return "Tennis fortune: " + fortuneService.getFortune();
    }
}
