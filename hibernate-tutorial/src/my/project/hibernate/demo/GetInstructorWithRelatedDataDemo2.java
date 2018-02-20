package my.project.hibernate.demo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.project.hibernate.demo.entity.Course;
import my.project.hibernate.demo.entity.Instructor;
import my.project.hibernate.demo.entity.InstructorDetail;

public class GetInstructorWithRelatedDataDemo2 {

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
				System.out.println("\nBefore tmpInstructor.getCourses()");
				List <Course>courses = tmpInstructor.getCourses();
				System.out.println("\nAfter tmpInstructor.getCourses(), before println-ing courses' list");
				System.out.println(courses);
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
