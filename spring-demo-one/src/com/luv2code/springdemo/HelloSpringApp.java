package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by David on 2017-08-02.
 */
public class HelloSpringApp {
    public static void main(String[] args) {

        // load the spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");


        // retrieve bean form spring container
        Coach theCoach = context.getBean("myCoach", Coach.class);

        // call methods on the bean
        System.out.println(theCoach.getDailyWorkout());

        // calling new methods for the fortune service
        System.out.println(theCoach.getDailyFortune());

        // close the context
        context.close();

    }
}
