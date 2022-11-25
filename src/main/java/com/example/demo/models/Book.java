package com.example.demo.models;


import javax.persistence.Entity;
import javax.persistence.Id;

//Entity para identificar que es una representacion de una tabla de sql
@Entity
public class Book {
    //Id para identificar al isbn como el id de la tabla sql
    @Id
    private String isbn;
    private String title;
    private String category;
    private Integer quantity;

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
}