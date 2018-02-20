package my.project.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.project.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// read students' data from student table
			session.beginTransaction();
			List<Student> students = session.createQuery("from Student", Student.class).getResultList();
			displayStudents(students);
			students = session.createQuery("from Student s where s.lastName='Trela'", Student.class).getResultList();
			displayStudents(students);
			students = session.createQuery("from Student s where s.lastName='Trela' OR s.firstName='Drugi'", Student.class).getResultList();
			displayStudents(students);
			students = session.createQuery("from Student s where s.firstName LIKE '%y'", Student.class).getResultList();
			displayStudents(students);
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> students) {
//		for(Student tmpStudent : students) {
//			System.out.println(tmpStudent);
//		}
//		or i Java 8
		students.forEach(System.out::println);
		System.out.println("\n\n");
	}

}
