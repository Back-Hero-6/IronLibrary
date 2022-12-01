package com.example.demo.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Para definir que el valor authorId se autogenera
    private Integer authorId;
    private String name;
    private String email;
    //private Book authorBook; //1 to 1 relationship into book  PENDIENTE DE PONER LA SINTAXI


    // Relaciones
    @OneToMany(mappedBy = "author")
    private List<Book> bookList = new ArrayList<>();

    //Constructors

    public Author() {
    }

    public Author(String name, String email) {
        this.name = name;
        this.email = email;
    }

    //Getters & Setters

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
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

    @Override
    public String toString() {
        return "Author{" +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
