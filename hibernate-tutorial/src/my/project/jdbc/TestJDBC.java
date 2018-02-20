package my.project.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&useUnicode=yes&characterEncoding=UTF-8";
		String user = "hbstudent";
		String password = "hbstudent";
		try {
			System.out.println("Connecting to database " + jdbcUrl);
			Connection myConnection = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Connection successful! isValid=" + myConnection.isValid(0));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}