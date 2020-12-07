package com.example.H2DbDemo;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.H2DbDemo.model.Person;
import com.example.H2DbDemo.model.Student;
import com.example.H2DbDemo.model.University;
import com.example.H2DbDemo.repository.PersonRepository;
import com.example.H2DbDemo.repository.StudentRepository;
import com.example.H2DbDemo.repository.UniversityRepository;

@SpringBootApplication
public class H2DbDemoApplication {

	public static void main(String[] args) {
	  ConfigurableApplicationContext configurableApplicationContext =	
	    SpringApplication.run(H2DbDemoApplication.class, args);
	
	  StudentRepository studentRepository = 
		  configurableApplicationContext.getBean(StudentRepository.class);
	  UniversityRepository universityRepository = 
		  configurableApplicationContext.getBean(UniversityRepository.class);
	  
	  Student student1 = new Student();
	  Student student2 = new Student();
	  Student student3 = new Student();
	  student1.setIndexNumber("AA");
	  student2.setIndexNumber("BB");
	  student3.setIndexNumber("DD");
	  studentRepository.save(student3);
	  List<Student> students = Arrays.asList(student1, student2);
	  
	  University university = new University();
	  university.setName("CCC-CCC");
	  university.setStudents(students);
	  universityRepository.save(university);
	
//	  universityRepository.delete(university);
	}

}
