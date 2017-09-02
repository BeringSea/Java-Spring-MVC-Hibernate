package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by David on 2017-08-06.
 */
public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {

        // load spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // retreave bean from spring container
        Coach theCoach = context.getBean("tennisCoach",Coach.class);

        Coach alphaCoach = context.getBean("tennisCoach",Coach.class);

        // check if they are the same object
        boolean result = (theCoach==alphaCoach);

        // print aut the result
        System.out.println("\nPointing to the same object: "+result);
        System.out.println("\nMemory location for theCoach: "+theCoach);
        System.out.println("\nMemory location form alphaCoach: "+alphaCoach+"\n");

        // close context
        context.close();

    }
}
