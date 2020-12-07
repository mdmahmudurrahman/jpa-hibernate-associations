package com.example.H2DbDemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.H2DbDemo.model.University;

public interface UniversityRepository extends CrudRepository<University, Long> {

}
