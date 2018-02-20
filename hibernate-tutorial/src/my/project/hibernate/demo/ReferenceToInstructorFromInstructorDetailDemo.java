package my.project.hibernate.demo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.project.hibernate.demo.entity.Instructor;
import my.project.hibernate.demo.entity.InstructorDetail;

public class ReferenceToInstructorFromInstructorDetailDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// get instructor details object and reference to associated instructor
			session.beginTransaction();
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter instructor detail id: ");
			int id = scanner.nextInt();
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
			if (instructorDetail!=null) {
				System.out.println("Found details: " + instructorDetail);
				System.out.println("Associated instructor: " + instructorDetail.getInstructor());
			}
			else {
				System.out.println("Details with id " + id + " not found.");
			}
			session.getTransaction().commit();
			scanner.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
