package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by David on 2017-08-06.
 */
public class SwimCoach implements Coach {

    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

    private FortuneService fortuneService;

    public SwimCoach(FortuneService fortuneService) {
        System.out.println("Inside the SwimCoach constructor ...");
        this.fortuneService = fortuneService;
    }

    @Override
    public String gedDailyWorkout() {
        return "Swim 1000 meters as a worm up";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }
}
