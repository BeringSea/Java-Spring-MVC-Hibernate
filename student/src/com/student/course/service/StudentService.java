package com.student.course.service;

import com.student.course.entity.Course;
import com.student.course.entity.Student;

import java.util.List;

/**
 * Created by David on 2017-09-29.
 */
public interface StudentService {
    List<Student> getStudents();
    void saveStudent(Student theStudent, int[] idKurs);
    Student getStudent(int theId);
    void deleteStudent(int theId);
    List<Course> getStudentCourses(int theId);
    void updateStudent(Student theStudent, int[] idKurs);
}
