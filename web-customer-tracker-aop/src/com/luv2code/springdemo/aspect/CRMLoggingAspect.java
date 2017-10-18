package com.luv2code.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * Created by David on 2017-10-18.
 */
@Aspect
@Component
public class CRMLoggingAspect {

    // setup logger for correct display in console
    Logger myLogger = Logger.getLogger(getClass().getName());

    // setup pointcut declarations for controller
    @Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
    private void forControllerPackage(){}

    // setup pointcut declarations for service
    @Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
    private void forServicePackage(){}

    // setup pointcut declarations for dao
    @Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    // combine pointcuts for new declaration
    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow(){}

    // add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint){

        // display method we are calling
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("=====>>> in @Before: calling method: " + theMethod);

        // display the arguments to the method
        // get the arguments
        Object[] args = theJoinPoint.getArgs();

        // loop trough and display args
        for (Object arg : args) {
            myLogger.info("=====>>> argument: " + arg);
        }
    }

    // add @AfterReturning advice
    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult"
    )
    public void afterReturning(JoinPoint theJoinPoint, Object theResult){

        // display the method we are returning from
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("=====>>> in @AfterReturning: from method: " + theMethod);

        // display data returned
        myLogger.info("=====>>> result: " + theResult);
    }
}
