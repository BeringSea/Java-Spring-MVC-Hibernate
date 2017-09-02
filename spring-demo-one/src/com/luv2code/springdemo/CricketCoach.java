package com.luv2code.springdemo;

/**
 * Created by David on 2017-08-02.
 */
public class CricketCoach implements Coach {

    private FortuneService fortuneService;

    private String emailAddress;
    private String team;

    // create no-arg constructor

    public CricketCoach() {
        System.out.println("Cricket coach: inside no-arg constructor");
    }


    public void setEmailAddress(String emailAddress) {
        System.out.println("Cricket coach: inside setter method - setEmailAddress");
        this.emailAddress = emailAddress;
    }

    public void setTeam(String team) {
        System.out.println("Cricket coach: inside setter method - setTeam");
        this.team = team;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getTeam() {
        return team;
    }

    // our setter method
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("Cricket coach: inside setter method - setFortuneService");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
