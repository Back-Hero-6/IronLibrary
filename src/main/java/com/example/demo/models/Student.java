package com.example.demo.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    @OneToOne(mappedBy = "issueStudent") //Relacion
    private String usn;
    private String name;

    //Relaciones
    @OneToMany(mappedBy = "student")
    private List<Issue> issueList = new ArrayList<>();


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

    public List<Issue> getIssueList() {
        return issueList;
    }

    public void setIssueList(List<Issue> issueList) {
        this.issueList = issueList;
    }
}
