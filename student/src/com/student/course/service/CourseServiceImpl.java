package com.student.course.service;

import com.student.course.dao.CourseDAO;
import com.student.course.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by David on 2017-09-29.
 */
@Service
public class CourseServiceImpl implements CourseService{

    // dependency injection for student DAO
    @Autowired
    private CourseDAO courseDAO;

    @Override
    @Transactional
    public List<Course> getCourses() {
        return courseDAO.getCourses();
    }

    @Override
    @Transactional
    public void saveCourse(Course theCourse) {
        courseDAO.saveCourse(theCourse);
    }

    @Override
    @Transactional
    public Course getCourse(int theId) {
        return courseDAO.getCourse(theId);
    }

    @Override
    @Transactional
    public void deleteCourse(int theId) {
        courseDAO.deleteCourse(theId);
    }
}
