package com.springboot.rest.deptcrudjersey.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.springboot.rest.deptcrudjersey.interceptor.DeptInterceptor;

@Configuration
public class AppConfiguration implements WebMvcConfigurer{
	
	@Autowired
	DeptInterceptor deptInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(deptInterceptor);
	}

}
