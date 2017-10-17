package com.luv2code.aopdemo.com.luv2code.aopdemo.aspect;
import com.luv2code.aopdemo.com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by David on 2017-10-13.
 */
@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    // add a new advice for @After on the findAccounts method
    @After("execution(* com.luv2code.aopdemo.com.luv2code.aopdemo.aop.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint){

        // print witch method we  are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @After (finally) on method: " + method);
    }

    // add a new advice for @AfterThrowing on the findAccounts method
    @AfterThrowing(
            pointcut = "execution(* com.luv2code.aopdemo.com.luv2code.aopdemo.aop.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc){

        // print witch method we  are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);

        // log the exception
        System.out.println("\n=====>>> The exception is: " + theExc);
    }


    // add a new advice for @AfterReturning on the findAccounts method
    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopdemo.com.luv2code.aopdemo.aop.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result){

        // print witch method we  are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);

        // print out the result of the method call
        System.out.println("\n=====>>> result is: " + result);

        // let's post-process the data ... let's modify it

        // convert the account names to uppercase
        convertAccountNamesToUpperCAse(result);
        System.out.println("\n=====>>> result is: " + result);
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
        System.out.println("\n=====>>>>> Executing @Before advice on method");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        // display the method arguments
        Object[] args = theJoinPoint.getArgs();
        for (Object tempArg : args) {
            System.out.println(tempArg);
            if(tempArg instanceof Account){
                // downcast and print Account specific stuff
                Account theAccount = (Account) tempArg;
                System.out.println("Account name: " + theAccount.getName());
                System.out.println("Account level: " + theAccount.getLevel());
            }
        }
    }
}
