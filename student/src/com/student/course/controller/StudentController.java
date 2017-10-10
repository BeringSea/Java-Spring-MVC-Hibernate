package com.student.course.controller;

import com.student.course.dao.StudentDAO;
import com.student.course.entity.Course;
import com.student.course.entity.Student;
import com.student.course.service.CourseService;
import com.student.course.service.StudentService;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 2017-09-29.
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    // inject our student service
    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/list")
    public String listStudents(@ModelAttribute("flash") String flash, Model theModel){
        // getting students from student service
        List<Student> theStudents = studentService.getStudents();

        // add students to the model
        theModel.addAttribute("students", theStudents);

        return "list-students";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Student theStudent =  new Student();
        List<Course> courses = courseService.getCourses();
        theModel.addAttribute("student",theStudent);
        theModel.addAttribute("courses",courses);
        return "student-form";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@Valid @ModelAttribute("student") Student theStudent, BindingResult theBindingResult, @RequestParam("lista[]") int[] idKurs){
        // saving student using student service
        if(theBindingResult.hasErrors()){
            return "student-form";
        }
        studentService.saveStudent(theStudent, idKurs);
        return "redirect:/student/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel){

        // get the student from student service
        List<Course> courses = courseService.getCourses();
        Student theStudent = studentService.getStudent(theId);

        // set student as a model attribute to pre-populate form
        theModel.addAttribute("studentUpdate", theStudent);
        theModel.addAttribute("courses",courses);

        // send over to our form
        return "update-student-form";
    }

    @PostMapping("/updateStudent")
    public String updateStudent(@RequestParam("lista[]") int[] idKurs,@Valid @ModelAttribute("studentUpdate") Student theStudent, BindingResult theBindingResult){
        if(theBindingResult.hasErrors()){
            return "update-student-form";
        }
        studentService.updateStudent(theStudent,idKurs);
        return "redirect:/student/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("studentId") int theId){
        // delete the student
        studentService.deleteStudent(theId);

        return "redirect:/student/list";
    }
    @GetMapping("/showStudentCourses")
    public String showStudentCourses(@RequestParam("studentId") int theId, Model theModel){
        List<Course> studentCourses = studentService.getStudentCourses(theId);
        Student tempStudent = studentService.getStudent(theId);
        theModel.addAttribute("courses",studentCourses);
        theModel.addAttribute("student",tempStudent);
        return "student-courses";
    }
}
