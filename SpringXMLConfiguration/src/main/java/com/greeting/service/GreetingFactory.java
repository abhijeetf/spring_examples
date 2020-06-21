package com.greeting.service;

import com.greeting.service.EnglishGreetingService;
import com.greeting.service.GreetingService;
import com.greeting.service.HindiGreetingService;
import com.greeting.service.MarathiGreetingService;
import com.greeting.service.SpanishGreetingService;

public class GreetingFactory {
	
	public GreetingService createGreetingService(String lang) {
		GreetingService service = null;
		switch(lang) {
			case "english":
				service = new EnglishGreetingService();
				break;
			case "hindi":
				service = new HindiGreetingService();
				break;
			case "marathi":
				service = new MarathiGreetingService();
				break;
			case "spanish":
				service = new SpanishGreetingService();
				break;
			case "french":
				service = new FrenchGreetingService();
				break;
			default:
				service = new EnglishGreetingService();
				break;
		}
		return service;
	}
	
}
