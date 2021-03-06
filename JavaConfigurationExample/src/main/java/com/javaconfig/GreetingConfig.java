package com.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/*
 * @Configuration Indicates that a class declares one or more @Bean methods and may be processed by the Spring container to 
 * generate bean definitions and service requests for those beans at runtime. 
 * Bootstrapping @Configuration classes
 * 	Via AnnotationConfigApplicationContext
 * 		 @Configuration classes are typically bootstrapped using either AnnotationConfigApplicationContext or its web-capable variant, 
 * 		  AnnotationConfigWebApplicationContext.
 * 	Via Spring <beans> XML
 * 				<beans>
 *   					<context:annotation-config/>
 *   					<bean class="com.acme.AppConfig"/>
 *				</beans>
 *  Via component scanning
 *  	@Configuration is meta-annotated with @Component, therefore @Configuration classes are candidates for component scanning.
 */

@Configuration
public class GreetingConfig {
	
	@Bean
	@Profile({"default","english"})
	public GreetingService getEnglishGreetingService() {
		return new EnglishGreetingService();
	}
	
	@Bean
	@Profile("hindi")
	public GreetingService getHindiGreetingService() {
		return new HindiGreetingService();
	}
	
	@Bean
	@Profile("marathi")
	public GreetingService getMarathiGreetingService() {
		return new MarathiGreetingService();
	}
	
	@Bean("greetingController")
	public GreetingController getGreetingController() {
		return new GreetingController();
	}
}
