package my.project.springdemo;

import org.springframework.stereotype.Component;

// @Component("databaseFortuneService")
@Component //default name - its databaseFortuneService
public class DatabaseFortuneService implements FortuneService {
	
	public DatabaseFortuneService() {
		System.out.println(this.getClass().getSimpleName() + ": running default constructor");
	}
	
	@Override
	public String getFortune() {
		return this.getClass().getSimpleName() + " says: greetings from database!";
	}

}
