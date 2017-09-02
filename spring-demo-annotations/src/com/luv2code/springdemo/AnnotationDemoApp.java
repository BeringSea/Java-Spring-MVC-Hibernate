package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by David on 2017-08-03.
 */
public class AnnotationDemoApp {
    public static void main(String[] args) {
        // get spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // get the bean from spring container
        Coach theCoach = context.getBean("trackCoach", Coach.class);

        // call a method from a bean
        System.out.println(theCoach.gedDailyWorkout());

        // call method to get daily fortune
        System.out.println(theCoach.getDailyFortune());

        // close the context
        context.close();
    }
}
