package com.student.course.entity;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 2017-09-29.
 */
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    @NotNull(message = "Field is required ...")
    private String firstName;

    @Column(name = "last_name")
    @NotNull(message = "Field is required ...")
    private String lastName;

    @Column(name = "address")
    @NotNull(message = "Field is required ...")
    private String address;

    @Column(name = "city")
    @NotNull(message = "Field is required ...")
    private String city;

    @Column(name = "email")
    @NotNull(message = "Field is required ...")
    @Email(message = "wrong e-mail format ...")
    private String email;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "course_student", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;

    public Student(){

    }

    public Student(String firstName, String lastName, String address, String city, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    // add a convenience method for adding course to the student
    public void addCourse(Course theCourse){
        if(courses == null){
            courses = new ArrayList<>();
        }
        courses.add(theCourse);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
