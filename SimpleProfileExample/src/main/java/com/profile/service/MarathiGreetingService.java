package com.profile.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("marathi")
public class MarathiGreetingService implements GreetingService{

	@Override
	public String showGreeting() {
		return "Namaskaar!! Spring cha duniyet tumche swagat aahe!! ";
	}
	
}
