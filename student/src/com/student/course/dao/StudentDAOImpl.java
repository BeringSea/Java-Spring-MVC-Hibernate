package com.student.course.dao;

import com.student.course.entity.Course;
import com.student.course.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 2017-09-29.
 */
@Repository
public class StudentDAOImpl implements StudentDAO {

    // dependency injection for Session Factory to make DAO talk to database
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Student> getStudents() {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create query
        Query<Student> theQuery = currentSession.createQuery("from Student order by lastName",Student.class);

        // execute query and get result list
        List<Student> students = theQuery.getResultList();

        // return the results
        return students;
    }

    @Override
    public void saveStudent(Student theStudent, int[] idKurs) {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        List<Course> listaUnetihKurseva = new ArrayList<>();
        for (int i = 0; i < idKurs.length; i++) {
            listaUnetihKurseva.add(currentSession.get(Course.class,idKurs[i]));
        }

        for (int i = 0; i < listaUnetihKurseva.size(); i++) {
            theStudent.addCourse(listaUnetihKurseva.get(i));
        }

        // save the student
        currentSession.save(theStudent);
    }

    @Override
    public Student getStudent(int theId) {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // read from database using primary key
        Student theStudent = currentSession.get(Student.class, theId);

        return theStudent;
    }

    @Override
    public void deleteStudent(int theId) {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // read from database using primary key
        Student tempStudent = currentSession.get(Student.class, theId);

        // delete student
        currentSession.delete(tempStudent);

    }

    @Override
    public List<Course> getStudentCourses(int theId) {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // read from database using primary key
        Student tempStudent = currentSession.get(Student.class, theId);

        // get student courses
        List<Course> theCourses = tempStudent.getCourses();
        return theCourses;
    }

    @Override
    public void updateStudent(Student theStudent, int[] idKurs) {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        List<Course> listaUnetihKurseva = new ArrayList<>();
        for (int i = 0; i < idKurs.length; i++) {
            listaUnetihKurseva.add(currentSession.get(Course.class,idKurs[i]));
        }

        for (int i = 0; i < listaUnetihKurseva.size(); i++) {
            theStudent.addCourse(listaUnetihKurseva.get(i));
        }

        // save the student
        currentSession.update(theStudent);
    }
}
