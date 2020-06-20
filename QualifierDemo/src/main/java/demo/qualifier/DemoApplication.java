package demo.qualifier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
Classes that can be used to bootstrap and launch a Spring application from a Java main method. 
By default class will perform the following steps to bootstrap yourapplication: 
	•Create an appropriate ApplicationContext instance (depending on yourclasspath)
	•Register a CommandLinePropertySource to expose command line arguments asSpring properties
	•Refresh the application context, loading all singleton beans
	•Trigger any CommandLineRunner beans
In most circumstances the static run(Object, String []) method can be called directly from your main method 
to bootstrap your application:  
		 @Configuration
		 @EnableAutoConfiguration
		 public class MyApplication  {
				 		// ... Bean definitions
				 public static void main(String[] args) throws Exception {
		   			SpringApplication.run(MyApplication.class, args);
		 		 }
		 }
 
*/
 
/*
	Indicates a configuration class that declares one or more @Bean methods and also triggers auto-configuration and 
	component scanning. 
	@SpringBootApplication is a convenience annotation that is equivalent to declaring :
		@Configuration
		@EnableAutoConfiguration
		@ComponentScan
 */

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
        
        /*
         * HelloWorldConstructorInjection will use "helloWorld" bean since the qualifier name is set to "world".
         */
        HelloWorldConstructorInjection constructorInjection = 
        			(HelloWorldConstructorInjection)ctx.getBean("helloWorldConstructorInjection");
        constructorInjection.getMessage();
        
        /*
         * HelloWorldSetterInjection will use "helloIndia" bean since the qualifier name is set to "india".
         */
        HelloWorldSetterInjection setterInjection = 
        						(HelloWorldSetterInjection) ctx.getBean("helloWorldSetterInjection");
        setterInjection.getMessage();
             
    }
}
