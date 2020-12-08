package com.example.H2DbDemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.H2DbDemo.model.Stream;

@Repository
public interface StreamRepository extends CrudRepository<Stream, Long> {

}
