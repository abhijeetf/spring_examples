package com.jpa;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


/**
 * Driver Class:	org.h2.Driver
 * JDBC URL:		jdbc:h2:mem:testdb
 * 
 * Inspect the H2 database via the DB console. (http://localhost:8080/h2-console) 
 * 
 */

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context =	SpringApplication.run(App.class, args);
        
        System.out.println("##########BeanDefinitionCount#############"+ context.getBeanDefinitionCount());
        Arrays.stream(context.getBeanDefinitionNames()).forEach( x -> System.out.println(x));
    }
}
