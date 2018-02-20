package my.project.hibernate.demo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.project.hibernate.demo.entity.Course;
import my.project.hibernate.demo.entity.Instructor;
import my.project.hibernate.demo.entity.InstructorDetail;

public class DeleteCourseDemo {

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
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.print("Give the course id: ");
			int courseId = scanner.nextInt();
			scanner.close();
			session.beginTransaction();
			Course myCourse = session.get(Course.class, courseId);
			if (myCourse != null) {
				session.delete(myCourse);
				session.getTransaction().commit();
			}
			else {
				System.out.println("Course with id " + courseId + " not found");
				session.getTransaction().rollback();
			}
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
