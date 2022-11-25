package com.example.demo.models;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    private String usn;
    private String name;


    //Constructors
    public Student() {
    }

    public Student(String usn, String name) {
        this.usn = usn;
        this.name = name;
    }

    //Getters & Setters

    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
