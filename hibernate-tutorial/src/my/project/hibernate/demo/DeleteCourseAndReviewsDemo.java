package my.project.hibernate.demo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.project.hibernate.demo.entity.Course;
import my.project.hibernate.demo.entity.Instructor;
import my.project.hibernate.demo.entity.InstructorDetail;
import my.project.hibernate.demo.entity.Review;

public class DeleteCourseAndReviewsDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// get a course and its reviews
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter course id: ");
			int courseId = scanner.nextInt();
			scanner.close();
			session.beginTransaction();
			Course course = session.get(Course.class, courseId);
			if (course!=null) {
				System.out.println("Course: " + course);
				System.out.println("Reviews: " + course.getReviews());
				session.delete(course);
				System.out.println("Course with its reviews deleted");
			}
			else {
				System.out.println("There is no course with id " + courseId + ".");
			}
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
