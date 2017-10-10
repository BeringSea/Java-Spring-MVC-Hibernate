package com.student.course.dao;

import com.student.course.entity.Course;
import com.student.course.entity.Grade;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by David on 2017-10-02.
 */
@Repository
public class GradeDAOImpl implements GradeDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void saveGrade(String name_lastname, String course_title, String period, int idGrade) {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        Grade theGrade = new Grade(name_lastname,course_title,period,idGrade);
        currentSession.save(theGrade);
    }

    @Override
    public List<Grade> selectAll() {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Grade> theQuery = currentSession.createQuery("from Grade",Grade.class);
        List<Grade> grades = theQuery.getResultList();
        return grades;
    }

    @Override
    public void delete(int theId) {
        Session currSession = sessionFactory.getCurrentSession();
        Grade grade = currSession.get(Grade.class, theId);
        currSession.delete(grade);
    }


}
