package demo.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldConstructorInjection {
		 
	private IHello hello ;
	
	/*
	 * Qualifier annotation is used to specify the qualifying name of the bean, of type IHello, which should be used for injection 
	 * during Auto Wiring.
	 */
	
	@Autowired
	public HelloWorldConstructorInjection(@Qualifier("world") IHello hello) {
		this.hello = hello;
	}
	
	public void getMessage() {
		this.hello.sayHello();
	}
}
