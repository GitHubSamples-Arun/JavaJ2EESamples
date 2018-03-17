
package com.jdbcWithSpring;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import com.jdbcWithSpring.Employee;
import com.jdbcWithSpring.EmployeesDao;

public class JdbcClient {
		public static void main(String[] args) 
		{
			ApplicationContext context = new FileSystemXmlApplicationContext("classpath:beans.xml");
			EmployeesDao empDao = context.getBean("employeesDaoBean",EmployeesDao.class);
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
	        Date date1 = null;
			try {
				date1 = sdf.parse("15-JAN-17");
			} catch (ParseException e) {
				e.printStackTrace();
			}
	        
			empDao.addEmployee(250, "Sam", "Thomas2", "Systems@2.com",date1,"SA_MAN",1000);
			System.out.println("**Created Employees***");
			
			//System.out.println("Total Number of Employees : " + empDao.getEmployeeCount());
			System.out.println("***List of Employees***");
			List<Employee> employees = empDao.getAllEmployees();
			for (int i = 0; i < employees.size(); i++) 
			{
				Employee employee = employees.get(i);
				System.out.println(employee.getFirstName() + " " + employee.getLastName() + " : " + employee.getDesignation());
			}
			System.out.println("***Deleting an employee***");
			empDao.deleteEmployee(251);
			//System.out.println("Total Number of Employees after deletion: " + empDao.getEmployeeCount());
		}
	}