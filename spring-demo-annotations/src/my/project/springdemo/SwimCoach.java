package my.project.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {
	private FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Swim 1000 meters as a worm up.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune() +"\nemail: " + email +"\nteam: "+team;
	}

}
