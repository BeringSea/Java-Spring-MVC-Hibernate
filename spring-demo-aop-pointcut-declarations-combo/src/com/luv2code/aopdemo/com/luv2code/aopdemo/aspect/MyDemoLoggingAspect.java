package com.luv2code.aopdemo.com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by David on 2017-10-13.
 */
@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // let's start with an @Before advice

    @Pointcut("execution(* com.luv2code.aopdemo.com.luv2code.aopdemo.aop.*.*(..))")
    private void forDaoPackage(){}

    // create pointcut for getter methods
    @Pointcut("execution(* com.luv2code.aopdemo.com.luv2code.aopdemo.aop.*.set*(..))")
    private void getters(){}

    // create pointcut for setter methods
    @Pointcut("execution(* com.luv2code.aopdemo.com.luv2code.aopdemo.aop.*.get*(..))")
    private void setters(){}

    // create point for exclude getter and setter
    @Pointcut("forDaoPackage() && !(getters() || setters())")
    private void forDaoPackageNoGettersSetters(){}

//    @Before("execution(public void  add*())") // all methods that start with add
    @Before("forDaoPackageNoGettersSetters()") // modifier is optional so we can remove it
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====>>>>> Executing @Before advice on method");
}

    @Before("forDaoPackageNoGettersSetters()")
    public void performAnalytics(){
        System.out.println("\n=====>>>>> Performing API analytics");
    }
}
