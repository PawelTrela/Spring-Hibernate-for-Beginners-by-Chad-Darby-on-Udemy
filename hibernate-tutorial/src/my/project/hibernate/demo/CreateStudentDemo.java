package my.project.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.project.hibernate.demo.entity.Student;

public class CreateStudentDemo {

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
			Student tmpStudent = new Student("Dziesiąty", "Żółciążkiewicz", "pwtrela@gmail.com", DateUtils.parseDate("1978-05-02"));
//			tmpStudent.setId(10); // id można ustawić tylko wtedy, gdy pole id nie ma adnotacji @GeneratedValue(strategy=GenerationType.IDENTITY)
			session.beginTransaction();
			session.save(tmpStudent);
			System.out.println(""+tmpStudent.getId());
			session.getTransaction().commit();
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			factory.close();
		}

	}

}
