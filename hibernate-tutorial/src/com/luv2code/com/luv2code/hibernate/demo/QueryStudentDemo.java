package com.luv2code.com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by David on 2017-08-11.
 */
public class QueryStudentDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Student.class)
                                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // start transaction
            session.beginTransaction();

            // query the students
            List<Student> theStudents = session.createQuery("from Student").getResultList();

            // display the students
            displayStudents(theStudents);

            // query students: lastName = 'Mojicevic'
            theStudents = session.createQuery("from Student s where s.lastName='Mojicevic'").getResultList();
            System.out.println("The students with last name 'Mojicevic'");
            displayStudents(theStudents);

            // query students: lastName = 'Mojicevic' or firstName = 'Marko'
            theStudents = session.createQuery("from Student s where s.lastName='Mojicevic' or s.firstName='Marko'").getResultList();
            System.out.println("Last name Mojicevic or first name Marko");
            displayStudents(theStudents);

            // query students whre email like '%gmail.com'
            theStudents = session.createQuery("from Student s where s.email like '%gmail.com'").getResultList();
            System.out.println("Students with email like '%email.com'");
            displayStudents(theStudents);


            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done ...");

        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for(Student tempStudent : theStudents){
            System.out.println(tempStudent);
        }
    }
}
