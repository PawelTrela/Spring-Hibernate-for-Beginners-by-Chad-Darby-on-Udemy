package my.project.hibernate.demo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.project.hibernate.demo.entity.Course;
import my.project.hibernate.demo.entity.Instructor;
import my.project.hibernate.demo.entity.InstructorDetail;

public class GetInstructorWithRelatedDataDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// get instructor from database with related data (details and courses)
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter instructor id: ");
			int instructorId = scanner.nextInt();
			scanner.close();
			session.beginTransaction();
			Instructor tmpInstructor = session.get(Instructor.class, instructorId);
			if (tmpInstructor!=null) {
				InstructorDetail details = tmpInstructor.getInstructorDetail();
				System.out.println(tmpInstructor);
				System.out.println(details);
				List <Course>courses = tmpInstructor.getCourses();
				//for(Course course: courses) {
					System.out.println(courses);
				//}
				// or, in shorter form:
				System.out.println(tmpInstructor.getCourses());
			}
			else {
				System.out.println("Instructor with id " + instructorId + " not found.");
			}
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
