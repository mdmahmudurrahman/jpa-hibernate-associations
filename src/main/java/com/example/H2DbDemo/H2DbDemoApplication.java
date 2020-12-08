package com.example.H2DbDemo;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.H2DbDemo.model.Person;
import com.example.H2DbDemo.model.Stream;
import com.example.H2DbDemo.model.Viewer;
import com.example.H2DbDemo.repository.PersonRepository;
import com.example.H2DbDemo.repository.StreamRepository;
import com.example.H2DbDemo.repository.ViewerRepository;

@SpringBootApplication
public class H2DbDemoApplication {

	public static void main(String[] args) {
	  ConfigurableApplicationContext configurableApplicationContext =	
	    SpringApplication.run(H2DbDemoApplication.class, args);
	
	  StreamRepository streamRepository = 
		  configurableApplicationContext.getBean(StreamRepository.class);
	  ViewerRepository viewerRepository = 
		  configurableApplicationContext.getBean(ViewerRepository.class);
	  
	  Viewer viewer1 = new Viewer("Viewer1");
	  Viewer viewer2 = new Viewer("Viewer2");
	  Viewer viewer3 = new Viewer("Viewer3");
	  Viewer viewer4 = new Viewer("Viewer4");
	  List<Viewer> viewers = Arrays.asList(viewer1, viewer2, viewer3, viewer4);
		
	  Stream stream1 = new Stream("Stream1");
	  Stream stream2 = new Stream("Stream2");
	  List<Stream> streams = Arrays.asList(stream1, stream2);
	  streamRepository.saveAll(streams);
	  
	  viewer1.followStream(stream1);
	  viewer2.followStream(stream2);
	  viewer3.followStream(stream2);
	  viewer4.followStream(stream1);
	  viewer4.followStream(stream2);
	  viewerRepository.saveAll(viewers);
	}

}
