package com.luv2code.com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by David on 2017-08-11.
 */
public class CreateStudentDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Course.class)
                                .addAnnotatedClass(Student.class)
                                .buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();

        try {

            // start transaction
            session.beginTransaction();


            // create the students
            Student tempStudent = new Student("Jovana","Sovilj","jovana@gmail.com");


            // save students
            System.out.println("\nSaving student ...");
            session.save(tempStudent);
            System.out.println("Saved students: "+tempStudent);

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done ...");

        } finally {
            factory.close();
        }
    }
}
