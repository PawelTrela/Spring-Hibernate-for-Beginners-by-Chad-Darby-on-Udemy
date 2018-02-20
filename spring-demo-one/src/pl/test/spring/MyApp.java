package pl.test.spring;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Coach theCoach = new TrackCoach(null);
		System.out.println(theCoach.getDailyWorkout());
	}

}
