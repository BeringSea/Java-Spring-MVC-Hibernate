package com.luv2code.com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by David on 2017-08-11.
 */
public class DeleteJavaCourseDemo {
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

            // get the Java course
            int courseId = 5;
            Course tempCourse = session.get(Course.class, courseId);

            // delete course
            System.out.println("\nDeleting the course: "+tempCourse);
            session.delete(tempCourse);


            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done ...");

        } finally {
            factory.close();
        }
    }
}
