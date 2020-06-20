package com.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.profile.controller.GreetingController;

@SpringBootApplication
public class SimpleProfileExampleApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SimpleProfileExampleApplication.class, args);
		GreetingController ctrl = (GreetingController) ctx.getBean("greetingController");
		System.out.println(ctrl.showGreeting());
	}

}
