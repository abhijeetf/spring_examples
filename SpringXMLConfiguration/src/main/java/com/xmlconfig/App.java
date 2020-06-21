package com.xmlconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.greeting.controller.GreetingController;

//@SpringBootApplication
//@ImportResource("classpath:/spring/spring-config.xml")

public class App 
{
	public static void main(String[] args) {
        //ApplicationContext ctx = SpringApplication.run(App.class, args);
		
		//Use below if VM argument for spring profile is not set :: -Dspring.profiles.active="spanish"
		//System.setProperty("spring.profiles.active", "spanish");
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring/spring-config.xml");
		
        GreetingController controller = (GreetingController) ctx.getBean("greetingController");

        System.out.println(controller.showGreeting());
    }
}
