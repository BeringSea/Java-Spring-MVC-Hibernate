package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by David on 2017-08-07.
 */
public class CrossfitAppDemo {
    public static void main(String[] args) {
        // read spring java config class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MySportConfig.class);

        // get the bean from spring container
        Coach theCoach = context.getBean("coachWithMyFortuneService", Coach.class);


        // call methods
        System.out.println(theCoach.gedDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        // close context
        context.close();
    }
}
