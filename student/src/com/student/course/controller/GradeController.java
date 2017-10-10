package com.student.course.controller;

import com.student.course.entity.Course;
import com.student.course.entity.Grade;
import com.student.course.entity.Student;
import com.student.course.service.CourseService;
import com.student.course.service.GradeService;
import com.student.course.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Created by David on 2017-10-02.
 */
@Controller
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private GradeService gradeService;

    @GetMapping("/listGrades")
    public String listGrades(Model theModel){
        List<Grade> grades = gradeService.selectAll();
        theModel.addAttribute("grades",grades);
        return "list-grades";
    }

    @GetMapping("/showFormForAddGrade")
    public String showFormForAdd(@RequestParam("studentId") int theId, RedirectAttributes ra, Model theModel){
        List<Course> courses = studentService.getStudentCourses(theId);
        Student theStudent = studentService.getStudent(theId);
        Grade theGrade = new Grade();
        theModel.addAttribute("grade",theGrade);
        theModel.addAttribute("courses",courses);
        theModel.addAttribute("student",theStudent);
        return "grade-form";
    }

    @PostMapping("/saveGrade")
    public String saveGrade(@RequestParam("studentId") int idStudent, @RequestParam("ddlCourse") int idCourse, @RequestParam("ddlPeriod") String period, @RequestParam("ddlGrade") int idGrade, @ModelAttribute("student") Student theStudent, RedirectAttributes redirect){
        // saving grade using grade service
        String name = studentService.getStudent(idStudent).getFirstName();
        String lastname = studentService.getStudent(idStudent).getLastName();
        String name_lastname = name + " " + lastname;
        String course_title = courseService.getCourse(idCourse).getTitle();
        List<Grade> grades = gradeService.selectAll();
        for (int i = 0; i < grades.size(); i++) {
            String baseName = grades.get(i).getStudent_name_lastname();
            String courseTitleBase = grades.get(i).getCourse_title();
            String periodBase = grades.get(i).getPeriod();
//            int markBase = grades.get(i).getMark();
            if(name_lastname.equals(baseName) && course_title.equals(courseTitleBase) && period.equals(periodBase)){
                redirect.addFlashAttribute("flash","Grade for particular course and period already in database ...");
                return "redirect:/student/list";
            }
        }
        gradeService.saveGrade(name_lastname,course_title,period,idGrade);
        return "redirect:/grade/listGrades";
    }

    @GetMapping("/deleteGrade")
    public String deleteGrade(@RequestParam("gradeId") int theId){
        gradeService.delete(theId);
        return "redirect:/student/list";
    }
}
