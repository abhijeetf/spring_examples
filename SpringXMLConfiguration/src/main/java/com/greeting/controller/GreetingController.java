package com.greeting.controller;

import com.greeting.service.GreetingService;

public class GreetingController {
	
	private GreetingService greetingService;
	
	private GreetingService marathiGreetingService ;
	
	private GreetingService hindiGreetingService ;
	
	public void setGreetingService(GreetingService greetingService) {
		this.greetingService = greetingService;
	}
	
	public void setMarathiGreetingService(GreetingService marathiGreetingService) {
		this.marathiGreetingService = marathiGreetingService;
	}
	
	public void setHindiGreetingService(GreetingService hindiGreetingService) {
		this.hindiGreetingService = hindiGreetingService;
	}

	public String showGreeting() {
		return this.greetingService.showGreeting() + " " + this.marathiGreetingService.showGreeting() + 
				"  " + this.hindiGreetingService.showGreeting();
	}
		
}
