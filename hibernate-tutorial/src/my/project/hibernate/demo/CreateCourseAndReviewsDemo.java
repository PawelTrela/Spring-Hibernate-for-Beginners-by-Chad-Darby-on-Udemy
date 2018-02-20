package my.project.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.project.hibernate.demo.entity.Course;
import my.project.hibernate.demo.entity.Instructor;
import my.project.hibernate.demo.entity.InstructorDetail;
import my.project.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

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
			// create a course and some reviews and save to database's tables using transaction
			session.beginTransaction();
			Course course = new Course("Course with reviews");
			course.addReview(new Review("Review 1 - 5 stars"));
			course.addReview(new Review("Review 2 - 1 star"));
			course.addReview(new Review("Review 3 - 4 stars"));
			session.save(course);
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
