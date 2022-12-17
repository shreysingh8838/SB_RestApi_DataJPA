package com.demorestapiandjpa.demorestapiandjpa.services;

import com.demorestapiandjpa.demorestapiandjpa.entity.Courses;

import java.util.List;

public interface CourseService {
    List<Courses> getCourses(); // get request (without filtering)

    Courses getCourse(Long courseId);    // get request by Id (filtering)

    String addCourse(Courses course);

    String updateCourse( Courses course);

    String deleteCourse(long courseId);

//    List<Courses> deleteCourse(int courseId);
}
