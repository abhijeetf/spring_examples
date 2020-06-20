package com.javaconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AppConfig {
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AppConfig.class, args);
		GreetingController ctrl  = (com.javaconfig.GreetingController) context.getBean("greetingController");
		System.out.println(ctrl.showGreeting());
	}
}
