package com.luv2code.springdemo.mvc;
import com.luv2code.springdemo.mvc.com.luv2code.springdemo.mvc.validation.CourseCode;

import javax.validation.constraints.*;

/**
 * Created by David on 2017-08-09.
 */
public class Customer {


    private String firstName;

    @NotNull(message = "Polje je obavezno ...")
    @Size(min=2, message = "Polje mora imati vise od 2 karaktera ...")
    private String lastName;

    @NotNull(message = "Polje je obavezno ...")
    @Min(value = 0, message = "Broj mora biti jednak ili veci od nule")
    @Max(value = 10,message = "Broj mora biti jednak ili manji od 10")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}",message = "Unesite brojeve/slova u duzini od pet karaktera")
    private String postalCode;

    @CourseCode(value = "Spring", message = "Unos mora poceti sa 'Spring' ...")
    private String courseCode;

    public Customer() {
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

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}

