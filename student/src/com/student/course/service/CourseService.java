package com.student.course.service;

import com.student.course.entity.Course;

import java.util.List;

/**
 * Created by David on 2017-09-29.
 */
public interface CourseService {
    List<Course> getCourses();
    void saveCourse(Course theCourse);
    Course getCourse(int theId);
    void deleteCourse(int theId);
}
