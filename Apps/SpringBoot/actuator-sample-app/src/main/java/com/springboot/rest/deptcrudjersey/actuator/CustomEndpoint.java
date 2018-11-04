package com.springboot.rest.deptcrudjersey.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Endpoint(id="customendpoint")
@Component
public class CustomEndpoint {
	
	@ReadOperation
	@Bean
	public String displayCustomEndpointMessage() {
		return "Try out other endpoints health,info,beans,env";
	}

}
