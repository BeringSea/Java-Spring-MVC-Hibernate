package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by David on 2017-08-03.
 */
public class BeanScopeDemoApp {
    public static void main(String[] args) {

        // load the spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        // retrieve beans from spring container
        Coach theCoach = context.getBean("myCoach",Coach.class);
        Coach alphaCoach = context.getBean("myCoach",Coach.class);

        // check if these are the same beans
        boolean result = theCoach==alphaCoach;

        // print out the results
        System.out.println("\nPointing to the same object: "+result);

        System.out.println("\nMemory location for theCoach: "+theCoach);
        System.out.println("\nMemory location for theCoach: "+alphaCoach+"\n");

        // close the context
        context.close();
    }
}
