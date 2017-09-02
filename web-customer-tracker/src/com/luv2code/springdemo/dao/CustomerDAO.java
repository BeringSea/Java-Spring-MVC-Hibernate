package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Customer;

import java.util.List;

/**
 * Created by David on 2017-08-20.
 */
public interface CustomerDAO {

     List<Customer> getCustomers();

     void saveCustomer(Customer theCustomer);

     Customer getCustomer(int theId);

     void deleteCustomer(int theId);
}
