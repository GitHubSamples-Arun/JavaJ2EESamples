package com.person;

public class Person {
 private String name;
 private Car car;
 
 public Person(Car car) {
	 this.car = car;
 }
 
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Car getCar() {
	return car;
}
public void setCar(Car car) {
	this.car = car;
}
 
 
}
