package com.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.profile.SimpleProfileExampleApplication;
import com.profile.controller.GreetingController;

/*
 * Exception in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'greetingController' available.
 * 		We get above exception if componentScan annotation is not used here to tell spring f/w in which package it has to look
 * for the components/annotaions. by default it will scan the package in which this class is present.
 * Either basePackageClasses or basePackages (or its alias value) may be specified to define specific packages to scan. 
 * If specific packages are not defined, scanning will occur from the package of the class that declares this annotation. 
 */

@SpringBootApplication
@ComponentScan("com.profile")
public class SimpleProfileApp {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SimpleProfileApp.class, args);
		GreetingController ctrl = (GreetingController) ctx.getBean("greetingController");
		System.out.println(ctrl.showGreeting());
	}

}

