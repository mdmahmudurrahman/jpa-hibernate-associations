package com.example.H2DbDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.H2DbDemo.model.Person;
import com.example.H2DbDemo.repository.PersonRepository;

@SpringBootApplication
public class H2DbDemoApplication {

	public static void main(String[] args) {
	  ConfigurableApplicationContext configurableApplicationContext =	
	    SpringApplication.run(H2DbDemoApplication.class, args);
	
	  PersonRepository personRepository = 
		  configurableApplicationContext.getBean(PersonRepository.class);
	  Person person = new Person();
	  person.setFirstName("dddd");
	  person.setLastName("VVVV");
	  personRepository.save(person);
		
	}

}
