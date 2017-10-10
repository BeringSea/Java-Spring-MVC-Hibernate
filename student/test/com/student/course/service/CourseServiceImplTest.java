package com.student.course.service;

import com.student.course.entity.Course;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by David on 2017-10-01.
 */
@Transactional
public class CourseServiceImplTest {

    @Autowired
    CourseServiceImpl impl;

    @Test
    public void test(){
        List<Course> courses = impl.getCourses();
        int size = 0;
        for (int i = 0; i < courses.size(); i++) {
            size++;
        }
        assertEquals(3, size);
    }

}
