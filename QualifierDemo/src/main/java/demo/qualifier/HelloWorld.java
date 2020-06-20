package demo.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


//@Component("world")
@Component

/*
*	This annotation may be used on a field or parameter as a qualifier for candidate beans when autowiring. 
*	Used to resolve the autowiring conflict, when there are multiple beans of same type.
*	HelloIndia and HelloWorld are beans of type IHello.
*	This "helloWorld" bean can be used with qualifier name "world". 
**/

@Qualifier("world")
public class HelloWorld implements IHello{
	
    public void sayHello(){
        System.out.println("Hello World!!!!");
    }
    
}
