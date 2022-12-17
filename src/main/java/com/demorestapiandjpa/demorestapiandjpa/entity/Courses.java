package com.demorestapiandjpa.demorestapiandjpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity     // Decorator of Entity Class - in DB the table will be generated with name of this class only
public class Courses {
    @Id // to make this variable as the primary key of the database
    private long id;
    private String title;
    private String description;



    //Constructor
    public Courses(String title, long id, String description) {
        super();
        this.title = title;
        this.id = id;
        this.description = description;
    }

    // Default Constructor
    public Courses(){
        super();
    }



    // All Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
