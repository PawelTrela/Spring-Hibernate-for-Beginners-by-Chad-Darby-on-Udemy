package my.project.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.project.hibernate.demo.entity.Course;
import my.project.hibernate.demo.entity.Instructor;
import my.project.hibernate.demo.entity.InstructorDetail;
import my.project.hibernate.demo.entity.Review;
import my.project.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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
			// create a course and students and save to database's tables using transaction
			session.beginTransaction();
			Course course = new Course("Course with students in join table");
			session.save(course);
			Student student1 = new Student("Pierwszy", "Student", "ąę@gmail.com", null);
			Student student2 = new Student("Drugi", "Student", "żźć@gmail.com", null);
			course.addStudent(student1);
			course.addStudent(student2);
			session.save(student1);
			session.save(student2);
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
