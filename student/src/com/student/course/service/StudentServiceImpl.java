package com.student.course.service;

import com.student.course.dao.StudentDAO;
import com.student.course.entity.Course;
import com.student.course.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by David on 2017-09-29.
 */
@Service
public class StudentServiceImpl implements StudentService {

    // dependency injection for student DAO
    @Autowired
    private StudentDAO studentDAO;

    @Override
    @Transactional
    public List<Student> getStudents() {
        return studentDAO.getStudents();
    }

    @Override
    @Transactional
    public void saveStudent(Student theStudent, int[] idKurs) {
        studentDAO.saveStudent(theStudent, idKurs);
    }

    @Override
    @Transactional
    public Student getStudent(int theId) {
        return studentDAO.getStudent(theId);
    }

    @Override
    @Transactional
    public void deleteStudent(int theId) {
        studentDAO.deleteStudent(theId);
    }

    @Override
    @Transactional
    public List<Course> getStudentCourses(int theId) {
        return studentDAO.getStudentCourses(theId);
    }

    @Override
    @Transactional
    public void updateStudent(Student theStudent, int[] idKurs) {
        studentDAO.updateStudent(theStudent,idKurs);
    }

}
