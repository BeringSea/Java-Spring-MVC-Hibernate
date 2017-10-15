package com.luv2code.aopdemo.com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by David on 2017-10-15.
 */
@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

    @Before("com.luv2code.aopdemo.com.luv2code.aopdemo.aspect.AopExpressions.forDaoPackageNoGettersSetters()")
    public void logToCloudAsync(){
        System.out.println("\n=====>>>>> Logging to Cloud in async fashion");
    }
}
