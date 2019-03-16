package com.springboot.rest.deptcrudjersey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.*")
public class DeptCrudJerseyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeptCrudJerseyApplication.class, args);
	}
}
