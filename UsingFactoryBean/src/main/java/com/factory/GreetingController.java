package com.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GreetingController {
	private GreetingService greetingService;
	
	private GreetingService spanishGreetingService ;
	
	private GreetingService hindiGreetingService ;
	
	
	// Autowiring using default Type or Primary Bean 
	public GreetingController(GreetingService greetingService) {
		this.greetingService = greetingService;
		System.out.println("inside GreetingController constructor ");
	}
	
	
	@Autowired		// Autowiring using Type or Primary Bean 		
	public void setGreetingService(GreetingService greetingService) {
		this.greetingService = greetingService;
		System.out.println("inside GreetingController setGreetingService ");
	}
	
	@Autowired
	@Qualifier("getSpanishGreetingService")		// Autowiring Using method name
	public void setSpanishGreetingService(GreetingService service) {
		this.spanishGreetingService = service;
	}
	
	@Autowired
	@Qualifier("hindi")			// Autowiring using Bean name
	public void setHindiGreetingService(GreetingService hindiGreetingService) {
		this.hindiGreetingService = hindiGreetingService;
	}

	public GreetingService getGreetingService() {
		return greetingService;
	}
		
	public String showGreeting() {
		return this.greetingService.showGreeting() + " " + this.spanishGreetingService.showGreeting() + 
				"  " + this.hindiGreetingService.showGreeting();
	}
	
}
