package my.project.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.project.hibernate.demo.entity.Student;

public class CreateAndReadStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create a student object and save to database's table using transaction
			Student tmpStudent = new Student("Ędward", "Żółciążkiewicz", "pwtrela@gmail.com", null);
			session.beginTransaction();
			session.save(tmpStudent);
			System.out.println(tmpStudent);
			session.getTransaction().commit();
			// read student's data from database based on the id
			session = factory.getCurrentSession();
			session.beginTransaction();
			Student tmpStudent2 = session.get(Student.class, tmpStudent.getId());
			System.out.println(tmpStudent2);
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}

	}

}
