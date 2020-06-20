package demo.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component("india")			
@Component					//	considered as candidates for auto-detection

/*
*	This annotation may be used on a field or parameter as a qualifier for candidate beans when autowiring. 
*	Is is Used to resolve the autowiring conflict, when there are multiple beans of same type.
*	HelloIndia and HelloWorld are beans of type IHello.
*	This "helloIndia" bean can be used with qualifier name "india". 
**/
@Qualifier("india")

public class HelloIndia implements IHello{

	@Override
	public void sayHello() {
		System.out.println("Hello India !!!");		
	}

}
