package com.example.StudentCrouse.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String groupName;
    @ManyToOne 
    private Course course;

    public Student() {}

    public Student(String name, String email, String groupName) {
        this.name = name;
        this.email = email;
        this.groupName = groupName;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getGroupName() { 
        return groupName; 
    }
    public void setGroupName(String groupName) { 
        this.groupName = groupName; 
    }
     public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
}
