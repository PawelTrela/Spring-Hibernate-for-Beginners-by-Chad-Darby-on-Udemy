package my.project.hibernate.demo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.project.hibernate.demo.entity.Instructor;
import my.project.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDemo {

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
			// get the instructor object by primary key and delete him
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter the instructor ID you want to delete: ");
			int instructorId = scanner.nextInt();
			System.out.println("\n\n");
			session.beginTransaction();
			Instructor tmpInstructor = session.get(Instructor.class, instructorId);
			if (tmpInstructor!=null) {
				System.out.println("Removing " + tmpInstructor);
				session.delete(tmpInstructor);
			}
			else {
				System.out.println("Instructor with given id not found in database.");
			}
			
			session.getTransaction().commit();
			scanner.close();
		}
		finally {
			factory.close();
		}

	}

}
