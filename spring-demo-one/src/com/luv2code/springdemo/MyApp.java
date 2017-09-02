package com.luv2code.springdemo;

/**
 * Created by David on 2017-08-02.
 */
public class MyApp {
    public static void main(String[] args) {

        // create the object
        Coach theCoach = new TrackCoach();

        // use the object
        System.out.println(theCoach.getDailyWorkout());
    }
}
