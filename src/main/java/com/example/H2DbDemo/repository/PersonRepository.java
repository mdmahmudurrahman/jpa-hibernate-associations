package com.example.H2DbDemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.H2DbDemo.model.Person;

@Repository // optional to use this annotation
public interface PersonRepository extends CrudRepository<Person, Long> {
  
}
