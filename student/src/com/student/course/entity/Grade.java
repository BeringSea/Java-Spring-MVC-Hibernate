package com.student.course.entity;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by David on 2017-10-02.
 */
@Entity
@Table(name = "grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "student_name_lastname")
    private String student_name_lastname;

    @Column(name = "course_title")
    private String course_title;

    @Column(name = "period")
    private String period;

    @Column(name = "mark")
    private int mark;

    public Grade() {
    }

    public Grade(String student_name_lastname, String course_title, String period, int mark) {
        this.student_name_lastname = student_name_lastname;
        this.course_title = course_title;
        this.period = period;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getStudent_name_lastname() {
        return student_name_lastname;
    }

    public void setStudent_name_lastname(String student_name_lastname) {
        this.student_name_lastname = student_name_lastname;
    }

    public String getCourse_title() {
        return course_title;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public void setCourse_title(String course_title) {
        this.course_title = course_title;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", mark=" + mark +
                ", student_name_lastname='" + student_name_lastname + '\'' +
                ", course_title='" + course_title + '\'' +
                '}';
    }
}
