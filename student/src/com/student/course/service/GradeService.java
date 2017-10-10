package com.student.course.service;

import com.student.course.entity.Grade;

import java.util.List;

/**
 * Created by David on 2017-10-02.
 */
public interface GradeService {
    void saveGrade(String name_lastname, String course_title, String period, int idGrade);
    List<Grade> selectAll();
    void delete(int theId);
}
