package com.person;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class PersonMain {
	
	public static void main(String[] args) 
	{
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:beans.xml");
		Person person1 = context.getBean(Person.class);
		System.out.println("Name" + ", " + person1.getName());
		System.out.println("Car model" + ", " + person1.getCar().getModel());
		System.out.println("Car color" + ", " + person1.getCar().getColor());
	}

}
