package com.luv2code.aopdemo.com.luv2code.aopdemo.aspect;
import com.luv2code.aopdemo.com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by David on 2017-10-13.
 */
@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    private Logger myLogger = Logger.getLogger(MyDemoLoggingAspect.class.getName());

    // add a new advice for @Around on the findAccounts method
    @Around("execution(* com.luv2code.aopdemo.com.luv2code.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{
        // print witch method we  are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        myLogger.info("\n=====>>> Executing @Around on method: " + method);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // now, let's execute the method
        Object result = theProceedingJoinPoint.proceed();

        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        myLogger.info("\n=====>>> Duration: " + duration / 1000 + " seconds");

        return result;
    }

    // add a new advice for @After on the findAccounts method
    @After("execution(* com.luv2code.aopdemo.com.luv2code.aopdemo.aop.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint){

        // print witch method we  are advising on
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n=====>>> Executing @After (finally) on method: " + method);
    }

    // add a new advice for @AfterThrowing on the findAccounts method
    @AfterThrowing(
            pointcut = "execution(* com.luv2code.aopdemo.com.luv2code.aopdemo.aop.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc){

        // print witch method we  are advising on
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n=====>>> Executing @AfterThrowing on method: " + method);

        // log the exception
        myLogger.info("\n=====>>> The exception is: " + theExc);
    }


    // add a new advice for @AfterReturning on the findAccounts method
    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopdemo.com.luv2code.aopdemo.aop.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result){

        // print witch method we  are advising on
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n=====>>> Executing @AfterReturning on method: " + method);

        // print out the result of the method call
        myLogger.info("\n=====>>> result is: " + result);

        // let's post-process the data ... let's modify it

        // convert the account names to uppercase
        convertAccountNamesToUpperCAse(result);
        myLogger.info("\n=====>>> result is: " + result);
    }

    private void convertAccountNamesToUpperCAse(List<Account> result) {

        // loop through accounts
        for (Account account : result) {

            // get the uppercase version of name
            String theUpperName = account.getName().toUpperCase();

            // update the name on the account
            account.setName(theUpperName);
        }
    }


    //    @Before("execution(public void  add*())") // all methods that start with add
    @Before("com.luv2code.aopdemo.com.luv2code.aopdemo.aspect.AopExpressions.forDaoPackageNoGettersSetters()") // modifier is optional so we can remove it
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
        myLogger.info("\n=====>>>>> Executing @Before advice on method");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        myLogger.info("Method: " + methodSignature);

        // display the method arguments
        Object[] args = theJoinPoint.getArgs();
        for (Object tempArg : args) {
            myLogger.info(tempArg.toString());
            if(tempArg instanceof Account){
                // downcast and print Account specific stuff
                Account theAccount = (Account) tempArg;
                myLogger.info("Account name: " + theAccount.getName());
                myLogger.info("Account level: " + theAccount.getLevel());
            }
        }
    }
}
