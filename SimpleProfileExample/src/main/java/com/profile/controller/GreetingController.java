package com.profile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.profile.service.GreetingService;

@Controller
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
