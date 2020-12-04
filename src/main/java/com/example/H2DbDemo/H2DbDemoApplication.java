package com.example.H2DbDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.H2DbDemo.model.Address;
import com.example.H2DbDemo.model.Person;
import com.example.H2DbDemo.model.User;
import com.example.H2DbDemo.repository.AddressRepository;
import com.example.H2DbDemo.repository.PersonRepository;
import com.example.H2DbDemo.repository.UserRepository;

@SpringBootApplication
public class H2DbDemoApplication {

	public static void main(String[] args) {
	  ConfigurableApplicationContext configurableApplicationContext =	
	    SpringApplication.run(H2DbDemoApplication.class, args);
	
	  UserRepository userRepository = 
		  configurableApplicationContext.getBean(UserRepository.class);
	  AddressRepository addressRepository = 
		  configurableApplicationContext.getBean(AddressRepository.class); 
	  
	  Address address = new Address();
	  address.setStreet("Street 1");
	  addressRepository.save(address);
	  
	  User user = new User();
	  user.setName("name1");
	  user.setAddress(address);
	  userRepository.save(user);
	}
}
