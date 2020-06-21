package com.factory;

public class GreetingFactory {
	
	public GreetingService createGreetingService(String lang) {
		GreetingService service = null;
		switch(lang) {
			case "english":
				service =  new EnglishGreetingService();
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
			default:
				service = new EnglishGreetingService();
				break;
		}
		return service;
	}
	
}
