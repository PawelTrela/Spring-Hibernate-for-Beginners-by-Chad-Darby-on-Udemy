package my.project.hibernate.demo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.project.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.print("Give the student id: ");
			int studentId = scanner.nextInt();
			scanner.close();
			session.beginTransaction();
			Student myStudent = session.get(Student.class, studentId);
			if (myStudent != null) {
				session.delete(myStudent);
				session.getTransaction().commit();
			}
			else {
				System.out.println("Student with id " + studentId + " not found");
				session.getTransaction().rollback();
			}
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("\n\nDelete bunch of students");
			session.createQuery("delete from Student where id>=60").executeUpdate();
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}

	}

}
