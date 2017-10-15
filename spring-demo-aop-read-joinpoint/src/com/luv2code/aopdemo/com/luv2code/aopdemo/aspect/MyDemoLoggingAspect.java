package com.luv2code.aopdemo.com.luv2code.aopdemo.aspect;
import com.luv2code.aopdemo.com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
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
