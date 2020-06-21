package com.factory;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

public class EnglishGreetingService implements GreetingService{

	public String showGreeting() {
		return "Hello !! Welcome to the world of Spring!! ";
	}

}
