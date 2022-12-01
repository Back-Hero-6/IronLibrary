package com.example.demo.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//Entity para identificar que es una representacion de una tabla de sql
@Entity
public class Book {
    //Id para identificar al isbn como el id de la tabla sql
    @Id
    @OneToOne//(mappedBy = "issueBook") //Relacion
    private String isbn;
    private String title;
    private String category;
    private Integer quantity;

    //Relaciones
    @ManyToOne
    @JoinColumn(name = "student_usn")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    //Constructores

    //Constructor vacio para el SQL obligatorio
    public Book() {
    }

    public Book(String isbn, String title, String category, Integer quantity) {
        this.isbn = isbn;
        this.title = title;
        this.category = category;
        this.quantity = quantity;
    }

    //Getters & Setters

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                ", author=" + author +
                '}';
    }
}

