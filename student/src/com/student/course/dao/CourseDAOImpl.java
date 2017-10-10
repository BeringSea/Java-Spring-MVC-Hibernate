package com.student.course.dao;

import com.student.course.entity.Course;
import com.student.course.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by David on 2017-09-29.
 */
@Repository
public class CourseDAOImpl implements CourseDAO {
    // dependency injection for Session Factory to make DAO talk to database

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Course> getCourses() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Course> theQuery = currentSession.createQuery("from Course order by title",Course.class);
        List<Course> courses = theQuery.getResultList();
        return courses;
    }

    @Override
    public void saveCourse(Course theCourse) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theCourse);
    }

    @Override
    public Course getCourse(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Course theCourse = currentSession.get(Course.class, theId);
        return theCourse;
    }

    @Override
    public void deleteCourse(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Course tempCourse = currentSession.get(Course.class, theId);
        currentSession.delete(tempCourse);
    }
}
