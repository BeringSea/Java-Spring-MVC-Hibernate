package com.luv2code.aopdemo.com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by David on 2017-10-13.
 */
@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // let's start with an @Before advice

//    @Before("execution(public void  add*())")
    @Before("execution(* com.luv2code.aopdemo.com.luv2code.aopdemo.aop.*.*(..))") // modifier is optional so we can remove it
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====>>>>> Executing @Before advice on method");
    }
}
