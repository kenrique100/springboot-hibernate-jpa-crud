package com.akentech.cruddemo.dao;

import com.akentech.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);
    List<Student> findAll();

    // Finding student by last name
    List<Student> findByLastName(String theLastName);

    // Updating objects by id
    void update(Student theStudent);
}
