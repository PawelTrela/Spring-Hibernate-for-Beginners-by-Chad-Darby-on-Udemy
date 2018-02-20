package pl.test.spring;

public class TrackCoach implements Coach {
	private FortuneService fortuneService;
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Just do it! " + fortuneService.getFortune();
	}
	
	public void initMethodOfTrackCoach() {
		System.out.println("Calling init method of " + this.getClass().getName());
	}
	
	public void destroyMethodOfTrackCoach() {
		System.out.println("Calling destroy method of " + this.getClass().getSimpleName());
	}

}
