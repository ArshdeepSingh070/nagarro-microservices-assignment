package com.nagarro.microservices.APIGateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServicesFallbackMethodController {
	
	  @GetMapping("/userServiceFallBack")
	    public String userServiceFallBackMethod() {
	        return "User Service is taking longer than Expected." +
	                " Please try again later";
	    }

	    @GetMapping("/providerServiceFallback")
	    public String departmentServiceFallBackMethod() {
	        return "Department Service is taking longer than Expected." +
	                " Please try again later";
	    }

}
