package com.springboot.rest.deptcrudjersey.client;

import org.springframework.web.client.RestTemplate;

public class DepartmentsRestClient {
	
	public static void main(String args[]) {
		DepartmentsRestClient deptRestClient = new DepartmentsRestClient();
		//deptRestClient.testGetAllDepartments();
		deptRestClient.testDepartmentById();
		
	}
	
	public void testGetAllDepartments() {
		
		final String url = "http://localhost:8080/rest/departments";
		
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(url, String.class);
		
		System.out.println("Department details from rest client....."+result);
		
	}
	
public void testDepartmentById() {
		
		final String url = "http://localhost:8080/rest/departments/10";
		
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(url, String.class);
		
		System.out.println("Department details from rest client....."+result);
		
	}

}
