package com.student.course.service;
import com.student.course.dao.GradeDAO;
import com.student.course.entity.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by David on 2017-10-02.
 */
@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeDAO gradeDAO;

    @Override
    @Transactional
    public void saveGrade(String name_lastname, String course_title, String period, int idGrade) {
        gradeDAO.saveGrade(name_lastname,course_title,period,idGrade);
    }

    @Override
    @Transactional
    public List<Grade> selectAll() {
        return gradeDAO.selectAll();
    }

    @Override
    @Transactional
    public void delete(int theId) {
        gradeDAO.delete(theId);
    }
}
