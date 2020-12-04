package com.example.H2DbDemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.H2DbDemo.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
