package com.student;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.student.dao.StudentDAOImpl;


public class StudentCRUDTest {
	  public static void main(String[] args) {
	      ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

	      StudentDAOImpl studentJDBCTemplate = 
	         (StudentDAOImpl)context.getBean("studentJDBCTemplate");
	      
	      System.out.println("------Records Creation--------" );
	      studentJDBCTemplate.create("Zara", 11);
	      studentJDBCTemplate.create("Nuha", 2);
	      studentJDBCTemplate.create("Ayan", 15);

	      System.out.println("------Listing Multiple Records--------" );
	      List<Student> students = studentJDBCTemplate.listStudents();
	      
	      int studentId = 0;
	      
	      for (Student record : students) {
	    	  if(record.getName().equalsIgnoreCase("Zara")) {
	    		  System.out.println("Setting student id for Zara");
	    		  studentId = record.getId();
	    	  }
	         System.out.print("ID : " + record.getId() );
	         System.out.print(", Name : " + record.getName() );
	         System.out.println(", Age : " + record.getAge());
	      }

	      System.out.println("----Updating Record with ID = 2 -----" );
	      studentJDBCTemplate.update(studentId, 20);

	      System.out.println("----Listing Record with ID =  -----" +studentId );
/*	      Student student = studentJDBCTemplate.getStudent(studentId);
	      System.out.print("ID : " + student.getId() );
	      System.out.print(", Name : " + student.getName() );
	      System.out.println(", Age : " + student.getAge());*/
	   }
	}