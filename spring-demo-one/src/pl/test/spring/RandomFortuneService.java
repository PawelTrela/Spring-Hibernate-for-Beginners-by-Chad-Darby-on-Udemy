package pl.test.spring;

import java.util.Random;

public class RandomFortuneService implements FortuneService {
	private String [] fortunes = new String[3];
	
	Random randomNumber = new Random();
	
	public RandomFortuneService() {
		fortunes[0]="Gratulacje nr 1!";
		fortunes[1]="Gratulacje nr 2!";
		fortunes[2]="Gratulacje nr 3!";
	}
	@Override
	public String getFortune() {
		return fortunes[randomNumber.nextInt(3)];
	}

}
