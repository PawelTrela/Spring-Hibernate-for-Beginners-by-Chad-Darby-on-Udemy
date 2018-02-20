package my.project.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")
@Component //component with default name (its name is tennisCoach)
//@Scope("prototype") //default scope (if not specified) is singleton
public class TennisCoach implements Coach {
	@Autowired
	@Qualifier("fileFortuneService")
	private FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	/*
	// Example of Autowired for constructor 
	@Autowired
	public TennisCoach(@Qualifier("randomFortuneService") FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	*/
	public TennisCoach() {
		System.out.println(this.getClass().getSimpleName() + ": inside default constructor");
	}
	
	// init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("TennisCoach - inside method doMyStartupStuff invoked by @PostConstruct annotation");
	}
	
	//destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("TennisCoach - inside method doMyCleanupStuff invoked by @PreDestroy annotation");
	}
	/*
	// Example of @Autowired for setter injection
	@Autowired
	public void setFortuneService(@Qualifier("randomFortuneService") FortuneService theFortuneService) {
	// public void doSomeCrazyStuff(FortuneService theFortuneService) { // this also works - @Autowired inject dependencies for any method
		System.out.println(this.getClass().getSimpleName() + ": inside setFortuneService method");
		this.fortuneService = theFortuneService;
	}
	*/
	
	@Override
	public String getDailyWorkout() {
		System.out.println(email);
		System.out.println(team);

		return "Returning value from getDailyWorkout() in object " + this.getClass().getName();
	}
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
