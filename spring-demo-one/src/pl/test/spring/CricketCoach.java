package pl.test.spring;

public class CricketCoach implements Coach {
	private FortuneService myFortuneService;
	private String emailAddress;
	private String team;
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		System.out.println(this.getClass().getName() + ": ustawiam w³asnoœæ emailAddress wartoœci¹ " + emailAddress);
	}

	public void setTeam(String team) {
		this.team = team;
		System.out.println(this.getClass().getName() + ": ustawiam w³asnoœæ team wartoœci¹ " + team);
	}

	public void setMyFortuneService(FortuneService myFortuneService) {
		this.myFortuneService = myFortuneService;
	}
	
	public CricketCoach() {
		System.out.println("Tworzenie obiektu klasy CricketCoach");
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "It's me, your cricket coach - please practice hard!";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "Message from cricket coach: " + myFortuneService.getFortune();
	}

}
