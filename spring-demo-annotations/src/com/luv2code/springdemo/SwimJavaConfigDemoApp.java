package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by David on 2017-08-06.
 */
public class SwimJavaConfigDemoApp {
    public static void main(String[] args) {
        // read spring java config class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        //get the bean from spring container
        SwimCoach theCoach = context.getBean("swimCoach",SwimCoach.class);

        // call method on the bean
        System.out.println(theCoach.gedDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        // call methods only available on the SwimCoach class
        System.out.println("SwimCoach email - "+theCoach.getEmail());
        System.out.println("SwimCoach team - "+theCoach.getTeam());

        // close context
        context.close();
    }
}
