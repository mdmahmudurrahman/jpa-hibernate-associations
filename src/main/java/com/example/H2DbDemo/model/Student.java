package com.example.H2DbDemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String indexNumber;

    public Student() {
    }

	public String getIndexNumber() {
	  return indexNumber;
	}

	public void setIndexNumber(String indexNumber) {
	  this.indexNumber = indexNumber;
	}
}
