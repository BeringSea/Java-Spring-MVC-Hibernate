package com.luv2code.aopdemo.com.luv2code.aopdemo.aop;

import com.luv2code.aopdemo.com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Component;

/**
 * Created by David on 2017-10-13.
 */
@Component
public class AccountDAO {

    public void addAccount(Account theAccount, boolean vipFlag){

        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    public boolean doWork(){
        System.out.println(getClass() + ": doWork()");
        return false;
    }
}
