package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //Para definir que el valor authorId se autogenera
    private Integer authorId;
    private String name;
    private String email;
    private Book authorBook; //1 to 1 relationship into book  PENDIENTE DE PONER LA SINTAXI

    //Constructors

    public Author() {
    }

    public Author(String name, String email, Book authorBook) {
        this.name = name;
        this.email = email;
        this.authorBook = authorBook;
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

    public Book getAuthorBook() {
        return authorBook;
    }

    public void setAuthorBook(Book authorBook) {
        this.authorBook = authorBook;
    }
}
