package com.luv2code.aopdemo;
import com.luv2code.aopdemo.com.luv2code.aopdemo.Account;
import com.luv2code.aopdemo.com.luv2code.aopdemo.aop.AccountDAO;
import com.luv2code.aopdemo.com.luv2code.aopdemo.aop.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by David on 2017-10-13.
 */
public class MainDemoApp {
    public static void main(String[] args) {

        // read spring config file
        AnnotationConfigApplicationContext context =  new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);

        // get membership bean from spring container
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        // call the account business method
        Account myAccount = new Account();
        myAccount.setName("Madhu");
        myAccount.setLevel("Platinum");
        theAccountDAO.addAccount(myAccount, true);
        theAccountDAO.doWork();

        // call the account dao getter/setter methods
        theAccountDAO.setName("foobar");
        theAccountDAO.setServiceCode("silver");

        String name = theAccountDAO.getName();
        String code = theAccountDAO.getServiceCode();

        // call the membership business method
        theMembershipDAO.addMember();
        theMembershipDAO.goToSleep();

        // close the context
        context.close();

    }
}
