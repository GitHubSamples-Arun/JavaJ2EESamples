package com.springboot.rest.deptcrudjersey.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class DeptInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger log = LoggerFactory.getLogger(DeptInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("In preHandle method of Interceptor");
		log.info("Request URL : = " + request.getRequestURL());
		
		if (request.getRequestURI().contains("/rest/departments/")) {
			validateUser();
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("In postHandle method of Interceptor");
		log.info("Request URL : = " + request.getRequestURL());
	}

	private void validateUser() {

	}

}
