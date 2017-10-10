package com.student.course.dao;

import com.student.course.entity.Course;

import java.util.List;

/**
 * Created by David on 2017-09-29.
 */
public interface CourseDAO {
    List<Course> getCourses();
    void saveCourse(Course theCourse);
    Course getCourse(int theId);
    void deleteCourse(int theId);
}
