package com.luv2code.com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by David on 2017-08-11.
 */
public class CreateCourseAndStudentDemo {
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

            // create a course
            Course tempCourse = new Course("Java");

            // save the course
            System.out.println("\nSaving the course ...");
            session.save(tempCourse);
            System.out.println("Saved the course: " + tempCourse);

            // create the students
            Student tempStudent1 = new Student("David","Mojicevic","dmojicevic@gmail.com");
            Student tempStudent2 = new Student("Marko","Pavlovic","pavlovic@gmail.com");

            // add students to the course
            tempCourse.addStudent(tempStudent1);
            tempCourse.addStudent(tempStudent2);

            // save students
            System.out.println("\nSaving student ...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            System.out.println("Saved students: "+tempCourse.getStudents());

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done ...");

        } finally {
            factory.close();
        }
    }
}
