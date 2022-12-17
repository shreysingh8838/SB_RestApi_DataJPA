package com.demorestapiandjpa.demorestapiandjpa.dao;

import com.demorestapiandjpa.demorestapiandjpa.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Courses, Long> {
    // in this Courses is the Entity class name - by this name only the table will be generated
    // and long is the datatype of the Primary key or @id variable of the Entity class.
}
