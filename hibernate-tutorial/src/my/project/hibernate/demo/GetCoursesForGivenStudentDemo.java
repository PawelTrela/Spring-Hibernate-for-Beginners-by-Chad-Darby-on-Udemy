package my.project.hibernate.demo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.project.hibernate.demo.entity.Course;
import my.project.hibernate.demo.entity.Instructor;
import my.project.hibernate.demo.entity.InstructorDetail;
import my.project.hibernate.demo.entity.Review;
import my.project.hibernate.demo.entity.Student;

public class GetCoursesForGivenStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// find the student and get his/her courses
			Scanner scanner = new Scanner(System.in);
			System.out.print("Give the student id: ");
			int studentId = scanner.nextInt();
			scanner.close();
			session.beginTransaction();
			Student student = session.get(Student.class, studentId);
			if (student!=null) {
				System.out.println("Student: " + student);
				System.out.println("Student's courses: " + student.getCourses());
			}
			else {
				System.out.println("Student with id " + studentId + " not found.");
			}
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
