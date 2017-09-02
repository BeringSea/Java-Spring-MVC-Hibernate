package com.luv2code.com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by David on 2017-08-11.
 */
public class PrimaryKeyDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // create 3 Student objects
            System.out.println("Creating a 3 new Student objects ...");
            Student tempStudent1 = new Student("Jovana","Sovolj","jovana@summa.com");
            Student tempStudent2 = new Student("Marko","Pavlovic","marko@gmail.com");
            Student tempStudent3 = new Student("Nenad","Nedic","nedic@gmail.com");

            // start transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student ...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done ...");

        } finally {
            factory.close();
        }
    }
}

