package my.project.hibernate.demo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.project.hibernate.demo.entity.Course;
import my.project.hibernate.demo.entity.Instructor;
import my.project.hibernate.demo.entity.InstructorDetail;
import my.project.hibernate.demo.entity.Review;
import my.project.hibernate.demo.entity.Student;

public class DeleteGivenCourseForGivenStudentDemo {

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
			// find the student and get his/her courses. Then delete selected course.
			Scanner scanner = new Scanner(System.in);
			System.out.print("Give the student id: ");
			int studentId = scanner.nextInt();
			session.beginTransaction();
			Student student = session.get(Student.class, studentId);
			if (student!=null) {
				System.out.println("Student: " + student);
				List<Course> courses = student.getCourses();
				for(Course course : courses) {
					System.out.println(course);
				}
				System.out.println("\n");
				courses.forEach(course -> System.out.println(course));
				System.out.println("\n");
				courses.forEach(System.out::println);
				System.out.println("\n");
				System.out.print("Give the course id to delete: ");
				int courseId = scanner.nextInt();
				boolean foundCourse = false;
				for(int i=0;i<courses.size();i++) {
					Course course = courses.get(i);
					if (course.getId() == courseId) {
						courses.remove(i);
						foundCourse = true;
						break;
					}
				}
				if (foundCourse == true) {
					session.save(student);
				}
				else {
					System.out.println("Course with id " + courseId + " not found.");
				}
			}
			else {
				System.out.println("Student with id " + studentId + " not found.");
			}
			scanner.close();
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
