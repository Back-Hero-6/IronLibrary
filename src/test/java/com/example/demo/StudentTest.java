package com.example.demo;

import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentTest {
    @Autowired
    StudentRepository studentRepository;
}
