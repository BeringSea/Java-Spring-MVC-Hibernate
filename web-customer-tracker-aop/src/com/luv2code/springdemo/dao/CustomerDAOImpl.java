package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NamedNativeQuery;
import java.util.List;

/**
 * Created by David on 2017-08-20.
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Customer> getCustomers() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();


        // create query and get result list
        List<Customer> customers = currentSession.createQuery("from Customer order by lastName").getResultList();
        // kod sa Query radi ali podvlaci kao gresku "from", zamenjen je sa linijom koda iznad
//        Query<Customer> theQuery = currentSession.createQuery("from Customer",Customer.class);

        // execute query and get result list
//        List<Customer> customers = theQuery.getResultList(); -> linija koda koja je vezana za Query

        // return the results
        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        // get hibernate session
        Session session = sessionFactory.getCurrentSession();

        // save or update Customer object in database
        session.saveOrUpdate(theCustomer);

    }

    @Override
    public Customer getCustomer(int theId) {
        Session session = sessionFactory.getCurrentSession();
        Customer theCustomer = session.get(Customer.class, theId);
        return theCustomer;
    }

    @Override
    public void deleteCustomer(int theId) {
        // get current hibernate session
        Session session = sessionFactory.getCurrentSession();

        // delete customer with primary key with HQL
        Query theQuery = session.createQuery("delete from Customer where id=:customerId");
        theQuery.setParameter("customerId",theId);
        theQuery.executeUpdate();
    }

}





















