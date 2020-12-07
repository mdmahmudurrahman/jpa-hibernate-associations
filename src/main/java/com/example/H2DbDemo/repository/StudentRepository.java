package com.example.H2DbDemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.H2DbDemo.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
