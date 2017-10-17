package com.luv2code.aopdemo;
import com.luv2code.aopdemo.com.luv2code.aopdemo.Account;
import com.luv2code.aopdemo.com.luv2code.aopdemo.aop.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Created by David on 2017-10-13.
 */
public class AfterFinallyDemoApp {
    public static void main(String[] args) {

        // read spring config file
        AnnotationConfigApplicationContext context =  new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);

        // call the method to find the accounts
        List<Account> theAccounts = null;
        try {
            // add a boolean flag to simulate exception
            boolean tripWire = false;
            theAccounts = theAccountDAO.findAccounts(tripWire);
        }
        catch (Exception exc){
            System.out.println("\n\nMain program ... caught exception: " + exc);
        }
        // display the accounts
        System.out.println("\n\nMain Program: AfterFinallyDemoApp");
        System.out.println("----");
        System.out.println(theAccounts);
        System.out.println("\n");

        // close the context
        context.close();

    }
}
