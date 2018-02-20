package my.project.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.project.hibernate.demo.entity.Course;
import my.project.hibernate.demo.entity.Instructor;
import my.project.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

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
			// create a instructor object and save to database's tables using transaction
			session.beginTransaction();
			Instructor tmpInstructor = new Instructor("Siódmy", "Instruktor", "pwtrela@gmail.com");
			InstructorDetail details = new InstructorDetail("http://youtu.be/siodmy", "siodmy");
			tmpInstructor.setInstructorDetail(details);
			Course course = new Course("Dla siódmego instruktora");
			tmpInstructor.addCourse(course);
			Course course2 = new Course("Dla siódmego instruktora - jeszcze jeden kurs");
			tmpInstructor.addCourse(course2);
			//course.setInstructor(tmpInstructor);
			session.save(tmpInstructor);
			session.save(course);
			session.save(course2);
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
