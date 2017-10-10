package com.student.course.controller;
import com.student.course.entity.Course;
import com.student.course.entity.Student;
import com.student.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.mock.staticmock.MockStaticEntityMethods;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by David on 2017-09-29.
 */
@Controller
@RequestMapping("/course")
public class CourseController {
    // inject our course service
    @Autowired
    private CourseService courseService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/list")
    public String listCourses(Model theModel){
        List<Course> theCourses = courseService.getCourses();
        theModel.addAttribute("courses",theCourses);
        return "list-courses";
    }
    @GetMapping("/showFormForAddCourse")
    public String showFormForAddCourse(Model theModel){
        Course theCourse = new Course();
        theModel.addAttribute("course",theCourse);
        return "course-form";
    }

    @PostMapping("/saveCourse")
    public String saveStudent(@Valid @ModelAttribute("course") Course theCourse, BindingResult theBindingResult){
        // saving course using course service
        if(theBindingResult.hasErrors()){
            return "course-form";
        }
        courseService.saveCourse(theCourse);
        return "redirect:/course/list";
    }

    @GetMapping("/showFormForUpdateCourse")
    public String showFormForUpdateCourse(@RequestParam("courseId") int theId, Model theModel){

        // get the course from student service
        Course theCourse = courseService.getCourse(theId);

        // set course as a model attribute to pre-populate form
        theModel.addAttribute("course", theCourse);

        // send over to our form
        return "course-form";
    }

    @GetMapping("/deleteCourse")
    public String delete(@RequestParam("courseId") int theId){
        // delete the course
        courseService.deleteCourse(theId);

        return "redirect:/course/list";
    }
}
