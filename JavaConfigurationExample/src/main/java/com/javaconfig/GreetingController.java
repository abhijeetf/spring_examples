package com.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class GreetingController {
	private GreetingService greetingService;

	public GreetingService getGreetingService() {
		return greetingService;
	}
	
	@Autowired
	public void setGreetingService(GreetingService greetingService) {
		this.greetingService = greetingService;
	}
	
	public String showGreeting() {
		return this.greetingService.showGreeting();
	}
	
}
