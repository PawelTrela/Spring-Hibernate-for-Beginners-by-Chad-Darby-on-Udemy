package my.project.hibernate.demo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.project.hibernate.demo.entity.Instructor;
import my.project.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

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
			// get the instructor detail object by primary key and delete it (delete also instruction as cascade delete)
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter the instructor detail ID you want to delete: ");
			int detailId = scanner.nextInt();
			scanner.close();
			System.out.println("\n\n");
			session.beginTransaction();
			InstructorDetail tmpInstructorDetail = session.get(InstructorDetail.class, detailId);
			if (tmpInstructorDetail!=null) {
				// remove the associated object reference to break bi-directional link
				tmpInstructorDetail.getInstructor().setInstructorDetail(null);
				System.out.println("Removing " + tmpInstructorDetail);
				session.delete(tmpInstructorDetail);
			}
			else {
				System.out.println("Instructor detail with given id not found in database.");
			}
			
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
