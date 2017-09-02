package com.luv2code.com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by David on 2017-08-11.
 */
public class DeleteInstructorDetailDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // start transaction
            session.beginTransaction();

            // get the instructor detail object
            int theId = 3;
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

            // print the instructor detail object
            System.out.println("Instuctor detail object: "+tempInstructorDetail);

            // print associated instructor
            System.out.println("The associated instructor: " + tempInstructorDetail.getInstructor());

            // remove the associated object reference, break bi-directional link
            tempInstructorDetail.getInstructor().setInstructorDetail(null);

            // delete instructor detail
            System.out.println("Deleting instructor tempInstructorDetail: " + tempInstructorDetail);
            // Note: will ALSO delete associated "instructor" for instructor because of CascadeType.ALL
            session.delete(tempInstructorDetail);

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done ...");

        }
        catch (Exception exc){
            exc.printStackTrace();
        }
        finally {
            // handle connection leak issue
            session.close();
            factory.close();
        }
    }
}
