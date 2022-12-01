package com.example.demo;

import com.example.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BookTest {
    @Autowired
    BookRepository bookRepository;

}
