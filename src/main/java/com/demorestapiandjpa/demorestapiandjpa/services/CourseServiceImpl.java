package com.demorestapiandjpa.demorestapiandjpa.services;

import com.demorestapiandjpa.demorestapiandjpa.dao.CourseDao;
import com.demorestapiandjpa.demorestapiandjpa.entity.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service     // Decorator for the service file
public class CourseServiceImpl implements CourseService {
    // Array containing OBJECTS of entity class Courses
    @Autowired
    private CourseDao courseDao;
    List<Courses> list;

    // default constructor
    public CourseServiceImpl(){
        list = new ArrayList<>();
        list.add(new Courses("English", 101, "This is Main"));
        list.add(new Courses("Maths", 201, "This is also Main"));
        list.add(new Courses("Physical Education", 301, "This is not Main"));
    }

    // to get all the courses
    @Override   // since it overrides the method of the interface whose method is implemented in this child class
    public List<Courses> getCourses() {     // providing the complete list
        return courseDao.findAll();
    }

    // get a course info by giving its course ID
    @Override
    public Courses getCourse(Long courseId){ // normally checking the object array which object contains this specific ID and will return the selected course(Object)
//        Courses res = null;
//        for(Courses courses: list) {
//            if (courses.getId() == courseId) {
//                res = courses;
//                break;
//            }
//        }
//        return res;

        return courseDao.getOne(courseId);
    }


    //course add
    @Override
    public String addCourse(Courses course){

//        list.add(course);
//        return list;
        courseDao.save(course);
        return "Course is now added";
    }

    // update course
    @Override
    public String updateCourse(Courses course){
//        list.forEach(e -> {
//            if(e.getId() == course.getId()){
//                e.setTitle(course.getTitle());
//                e.setDescription(course.getDescription());
//            }
//        });
        courseDao.save(course);
        return "Course is now updated";
    }

    @Override
    public String deleteCourse(long courseId){
        Courses courseEntity = courseDao.getOne(courseId);
        courseDao.delete(courseEntity);
        return "Course Deleted";
    }
}
