package my.project.springdemo;

import org.springframework.stereotype.Component;

// @Component("RESTFortuneService")
@Component //default name - its RESTFortuneService
public class RESTFortuneService implements FortuneService {
	
	public RESTFortuneService() {
		System.out.println(this.getClass().getSimpleName() + ": running default constructor");
	}
	
	@Override
	public String getFortune() {
		return this.getClass().getSimpleName() + " says: greetings from REST service!";
	}

}
