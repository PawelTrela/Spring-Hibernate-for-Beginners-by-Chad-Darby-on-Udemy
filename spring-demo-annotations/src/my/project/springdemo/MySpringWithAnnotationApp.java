package my.project.springdemo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySpringWithAnnotationApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		//Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune	());
//		Coach theCoach2 = context.getBean("trenerMuzyczny", Coach.class);
//		System.out.println(theCoach2.getDailyWorkout());
//		System.out.println(theCoach2.getDailyFortune());
		context.close();
	}
}
