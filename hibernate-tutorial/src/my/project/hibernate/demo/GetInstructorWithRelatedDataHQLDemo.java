package my.project.hibernate.demo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import my.project.hibernate.demo.entity.Course;
import my.project.hibernate.demo.entity.Instructor;
import my.project.hibernate.demo.entity.InstructorDetail;

public class GetInstructorWithRelatedDataHQLDemo {

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
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter instructor id: ");
			int instructorId = scanner.nextInt();
			scanner.close();
			session.beginTransaction();
			// when @OneToMay relation is set to fetch=FetchType.LAZY and we want to get object and
			// its related object using one shoot to database, we can create HQL query.
			// The clue is that we join tables using JOIN FETCH (not JOIN alone)
			Query<Instructor> query = session.createQuery("select i from Instructor i "
					+ "JOIN FETCH i.courses where i.id=:theInstructorId", Instructor.class);
			query.setParameter("theInstructorId", instructorId);
			Instructor tmpInstructor = query.getSingleResult();
			if (tmpInstructor!=null) {
				InstructorDetail details = tmpInstructor.getInstructorDetail();
				System.out.println(tmpInstructor);
				System.out.println(details);
				List <Course>courses = tmpInstructor.getCourses();
				//for(Course course: courses) {
					System.out.println(courses);
				//}
				// or, in shorter form:
				System.out.println(tmpInstructor.getCourses());
			}
			else {
				System.out.println("Instructor with id " + instructorId + " not found.");
			}
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
