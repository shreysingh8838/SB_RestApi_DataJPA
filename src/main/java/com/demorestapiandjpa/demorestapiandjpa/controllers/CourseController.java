package com.demorestapiandjpa.demorestapiandjpa.controllers;

import com.demorestapiandjpa.demorestapiandjpa.entity.Courses;
import com.demorestapiandjpa.demorestapiandjpa.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // it is a decorator or annotation used before using getmappings and other mappings as well
// Although it is a normal Controller decorator

@RequestMapping("/try")
// By this all the users will work and pass through this (i.e - localhost:8080/users/home)

public class CourseController {

        @Autowired
        // to let the interface know to make an object of the its child class which is implementing that interface (service) and will directly call that object at the same time
        private CourseService courseService;    // local object of CourseService

        //    private CourseService courseService2(2,4);
        public CourseController(CourseService courseService) {
            this.courseService = courseService; // copying a Service object (CourseService is an interface but using autowired decorator) it will create the object of its child class which implements that interface and will store it in the this local object courseService
        }

        // Sample Getrequest
        @GetMapping("/home")
        public String home() {
            return "this is string";
        }

    // Get request for complete list without any filter
    @GetMapping("/courses")
    public List<Courses> getCourses(){
        return courseService.getCourses();  // calling service method
    }

    // Get request by an id (with filter)
    @GetMapping("/courses/{courseId}")  //this {courstId}
    public Courses getCourse(@PathVariable String courseId){    // will be stored in this courseId in the String Datatype
        return this.courseService.getCourse(Long.parseLong(courseId));    // this string data will be parsed into Integer, Since its int in the services and entity
    }


    @PostMapping(value = "/courses", consumes = {"application/xml","application/json"})

    // Here this payload should be of both xml and json format to send the data
    // consumes = {"application/xml","application/json"}
    // otherwise it will show the error 415 unsupported data format
    // while making request from postman change the req from text to JSON
    public String addCourse(@RequestBody Courses course){
        return this.courseService.addCourse(course);
    }

    // request for testing purpose only
    @PostMapping("/newcourse")
    public String newcourse(){
        return "yes post working";
    }


    @PutMapping("/updatecourse")
    public String updateCourse(@RequestBody Courses course){
        return this.courseService.updateCourse(course);
    }

    @DeleteMapping("/deletecourse/{courseId}")
    public String deleteCourse(@PathVariable String courseId){
            return this.courseService.deleteCourse(Long.parseLong(courseId));
    }
//    @DeleteMapping("/deletecourse/{courseId}")
//    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseID){
//        try{
//            this.courseService.deleteCourse(Integer.parseInt(courseID));
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        catch( Exception e){
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}