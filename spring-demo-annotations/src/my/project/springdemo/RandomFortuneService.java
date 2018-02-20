package my.project.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

// @Component("randomFortuneService")
@Component //default name - its randomFortuneService
public class RandomFortuneService implements FortuneService {
	
	public RandomFortuneService() {
		System.out.println(this.getClass().getSimpleName() + ": running default constructor");
	}
	
	@Override
	public String getFortune() {
		Random rand = new Random();
		
		return this.getClass().getSimpleName() + " says: " + (rand.nextInt(100)+1) + " cheers from random service!";
	}

}
