package com.luv2code.com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by David on 2017-08-11.
 */
public class CreateInstructorDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .addAnnotatedClass(Course.class)
                                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // create the objects
            Instructor tempInstructor = new Instructor("David", "Mojicevic","dmojicevic@gmailc.o");
            InstructorDetail tempInstructorDetail = new InstructorDetail("My Chanel","Spring code practice");

            // associate the objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);


            // start transaction
            session.beginTransaction();

            // save the instructor
            // this will ALSO save the detail object because of CascadeType.ALL
            System.out.println("Saving instructor: " + tempInstructor);
            session.save(tempInstructor);


            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done ...");

        } finally {
            factory.close();
        }
    }
}
