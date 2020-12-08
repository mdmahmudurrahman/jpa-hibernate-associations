package com.example.H2DbDemo;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.H2DbDemo.model.Cart;
import com.example.H2DbDemo.model.Item;
import com.example.H2DbDemo.repository.CartRepository;
import com.example.H2DbDemo.repository.ItemRepository;

@SpringBootApplication
public class H2DbDemoApplication {

	public static void main(String[] args) {
	  ConfigurableApplicationContext configurableApplicationContext =	
	    SpringApplication.run(H2DbDemoApplication.class, args);
	
	  CartRepository cartRepository = 
		  configurableApplicationContext.getBean(CartRepository.class);
	  ItemRepository itemRepository = 
		  configurableApplicationContext.getBean(ItemRepository.class);
	  Cart cart = new Cart("Demo cart"); 
	  // Need to set cart also in the item, because the association is bidirectional
	  Item item1 = new Item("1A", cart);
	  Item item2 = new Item("1B", cart);
	  Item item3 = new Item("1A", cart);
	  // Item with no cart 
	  Item item4 = new Item();
	  item4.setSerialNumber("4AAAAAAA");
	  List<Item> items = Arrays.asList(item1, item2, item3);
	  
	  cart.setItems(items);
	  cartRepository.save(cart);
	  itemRepository.save(item4);
	  cartRepository.delete(cart);
	}
}
