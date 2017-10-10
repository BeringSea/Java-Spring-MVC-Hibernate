package com.luv2code.hibernate.demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 2017-08-15.
 */
@Entity
@Table(name = "course")
public class Course {
    // define our fields and annotate fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinTable(name = "course_student", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students;

    // define constructors

    public Course() {
    }

    public Course(String title) {
        this.title = title;
    }

    // define getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    // add a convenience method for adding student to the course
    public void addStudent(Student theStudent){
        if(students == null){
            students = new ArrayList<>();
        }
        students.add(theStudent);
    }

    // define toString

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
