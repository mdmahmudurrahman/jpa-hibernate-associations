package com.example.H2DbDemo;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.H2DbDemo.model.Car;
import com.example.H2DbDemo.model.Person;
import com.example.H2DbDemo.repository.CarRepository;
import com.example.H2DbDemo.repository.PersonRepository;

@SpringBootApplication
public class H2DbDemoApplication {
  
	public static void main(String[] args) {
	  ConfigurableApplicationContext configurableApplicationContext =	
	    SpringApplication.run(H2DbDemoApplication.class, args);
	
	  PersonRepository personRepository = 
		  configurableApplicationContext.getBean(PersonRepository.class);
	  CarRepository carRepository = 
		  configurableApplicationContext.getBean(CarRepository.class);
	  
	  Car car = new Car();
	  car.setModel("model1");
      carRepository.save(car);
      
	  Person person = new Person();
	  person.setFirstName("AAA");
	  person.setLastName("BBB");
	  person.setCar(car);
	  personRepository.save(person);
		
	  Optional<Car> optionalCar = carRepository.findById(1L);
	  Optional<Person> optionalPerson = personRepository.findById(1L);
	  
	  if (optionalCar.isPresent() && optionalPerson.isPresent()) {
		System.out.println("======= " + optionalCar.get() + " is owned by " + optionalCar.get().getPerson() + "=======");
		System.out.println("======= " + optionalPerson.get() + " has a  car " + optionalPerson.get().getCar() + "=======");
	  }
	}

}
