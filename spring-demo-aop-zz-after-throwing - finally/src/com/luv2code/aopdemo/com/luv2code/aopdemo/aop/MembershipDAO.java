package com.luv2code.aopdemo.com.luv2code.aopdemo.aop;

import org.springframework.stereotype.Component;

/**
 * Created by David on 2017-10-14.
 */
@Component
public class MembershipDAO {

    public boolean addMember(){
        System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
        return true;
    }

    public void goToSleep(){
        System.out.println(getClass() + ": I'm going to sleep now ...");
    }
}
