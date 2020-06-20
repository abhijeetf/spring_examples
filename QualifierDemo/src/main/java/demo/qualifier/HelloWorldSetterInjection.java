package demo.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldSetterInjection {
	
	IHello	hello;

	public IHello getHello() {
		return hello;
	}
	
	/*
	 * Qualifier annotation is used to specify the qualifying name of the bean, of type IHello, which should be used for injection 
	 * during Auto Wiring.
	 */
	
	@Autowired
	@Qualifier("india")
	public void setHello( IHello hello) {
		this.hello = hello;
	}
		
	public void getMessage() {
		this.hello.sayHello();
	}
	
}
