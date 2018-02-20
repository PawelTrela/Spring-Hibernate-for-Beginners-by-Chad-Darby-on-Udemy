package my.project.springdemo;

import org.springframework.stereotype.Component;

@Component("trenerMuzyczny")
public class MusicCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Your music coach says: practice 8 hours per day";
	}

	@Override
	public String getDailyFortune() {
		return null;
	}

}
