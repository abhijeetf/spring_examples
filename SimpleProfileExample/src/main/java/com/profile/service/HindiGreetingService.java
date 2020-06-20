package com.profile.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("hindi")
public class HindiGreetingService implements GreetingService {

	@Override
	public String showGreeting() {
		return "Namaste !! Spring ki duniya me aapka swaagat hai!! ";
	}

}
