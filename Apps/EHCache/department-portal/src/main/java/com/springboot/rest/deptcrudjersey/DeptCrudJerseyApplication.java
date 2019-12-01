package com.springboot.rest.deptcrudjersey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DeptCrudJerseyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeptCrudJerseyApplication.class, args);
	}
}
