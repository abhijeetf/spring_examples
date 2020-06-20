package com.profile.service;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"default","english"})

/* Indicates that a bean should be given preference when multiple candidates are qualified to autowire a single-valued dependency. 
 * If exactly one'primary' bean exists among the candidates, it will be the autowired value.
 */
//@Primary		 
public class EnglishGreetingService implements GreetingService{

	@Override
	public String showGreeting() {
		return "Hello !! Welcome to the world of Spring!! ";
	}

}
