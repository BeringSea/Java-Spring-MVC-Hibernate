package com.luv2code.com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by David on 2017-08-11.
 */
public class DeleteMarkoStudentDemoDemo {
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

            // get student Marko from database
            int studentId = 2;
            Student tempStudent = session.get(Student.class, studentId);
            System.out.println("\nLoaded student: "+tempStudent);
            System.out.println("\nCourses: "+tempStudent.getCourses());

            // delete the student
            System.out.println("\nDeleting the student: "+tempStudent);
            session.delete(tempStudent);


            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done ...");

        } finally {
            factory.close();
        }
    }
}
