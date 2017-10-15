package com.luv2code.aopdemo.com.luv2code.aopdemo.aspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by David on 2017-10-15.
 */
@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.luv2code.aopdemo.com.luv2code.aopdemo.aop.*.*(..))")
    public void forDaoPackage(){}

    // create pointcut for getter methods
    @Pointcut("execution(* com.luv2code.aopdemo.com.luv2code.aopdemo.aop.*.set*(..))")
    public void getters(){}

    // create pointcut for setter methods
    @Pointcut("execution(* com.luv2code.aopdemo.com.luv2code.aopdemo.aop.*.get*(..))")
    public void setters(){}

    // create point for exclude getter and setter
    @Pointcut("forDaoPackage() && !(getters() || setters())")
    public void forDaoPackageNoGettersSetters(){}
}
