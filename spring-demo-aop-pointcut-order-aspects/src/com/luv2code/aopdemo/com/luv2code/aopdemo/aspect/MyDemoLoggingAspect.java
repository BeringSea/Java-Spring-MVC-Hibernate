package com.luv2code.aopdemo.com.luv2code.aopdemo.aspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by David on 2017-10-13.
 */
@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

//    @Before("execution(public void  add*())") // all methods that start with add
    @Before("com.luv2code.aopdemo.com.luv2code.aopdemo.aspect.AopExpressions.forDaoPackageNoGettersSetters()") // modifier is optional so we can remove it
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====>>>>> Executing @Before advice on method");
}




}
