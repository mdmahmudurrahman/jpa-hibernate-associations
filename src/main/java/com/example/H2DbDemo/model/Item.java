package com.example.H2DbDemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Item")
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String serialNumber;
  @ManyToOne
  @JoinColumn(name = "cart_id")
  private Cart cart;
  
  public Item() {
  }
  
  public Item(String serialNumber, Cart cart) {
	this.serialNumber = serialNumber;
	this.cart = cart;
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }
}
