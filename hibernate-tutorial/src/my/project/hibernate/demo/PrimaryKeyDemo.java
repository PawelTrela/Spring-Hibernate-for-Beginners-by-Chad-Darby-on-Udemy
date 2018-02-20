package my.project.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.project.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create 3 student objects and save to database's table using transaction
			Student tmpStudent1 = new Student("Pierwszy", "Student", "pierwszy@gmail.com", null);
			Student tmpStudent2 = new Student("Drugi", "Student", "drugi@gmail.com", null);
			Student tmpStudent3 = new Student("Trzeci", "Student", "trzeci@gmail.com", null);
			session.beginTransaction();
			session.save(tmpStudent1);
			session.save(tmpStudent2);
			session.save(tmpStudent3);
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}
	}

}
