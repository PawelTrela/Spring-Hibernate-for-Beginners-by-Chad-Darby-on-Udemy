package my.project.springdemo;

import org.springframework.stereotype.Component;

// @Component("happyFortuneService")
@Component //default name - its happyFortuneService
public class HappyFortuneService implements FortuneService {
	
	public HappyFortuneService() {
		System.out.println(this.getClass().getSimpleName() + ": running default constructor");
	}
	
	@Override
	public String getFortune() {
		return this.getClass().getSimpleName() + " says: Today is your lucky day!";
	}

}
