package edu.fa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import edu.fa.model.Student;

@Component
public class StudentJdbcDao {
	private String jdbcUrl = "jdbc:sqlserver://localhost:1433;databaseName=education;user=sa;password=1234";
	private Connection connection = null;
	private Statement statement = null;

	public void insertStudent(Student student) {
		createConnection();
		try {
			statement = connection.createStatement();
			statement.execute("insert into namnv25.student values(" + student.getId() + ",'" + student.getName() + "','"
					+ student.getLocation() + "')");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public List<Student> getAllStudent() {
		createConnection();
		List<Student> students = new ArrayList<>();
		try {
			statement = connection.createStatement();
			ResultSet results = statement.executeQuery("select * from namnv25.student");
			while(results.next()) {
				int id = results.getInt(1);
				String name= results.getString(2);
				String location=results.getString(3);
				students.add(new Student(id,name,location));
			}
			results.close();
			statement.close();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return students;
	}
	
	private void createConnection() {
		if (connection == null) {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
				connection = DriverManager.getConnection(jdbcUrl);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

//	private void shutdown() {
//		try {
//			if (statement != null) {
//				statement.close();
//			}
//			if (connection != null) {
//				DriverManager.getConnection(jdbcUrl + ";shutdown=true");
//				connection.close();
//			}
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//		}
//	}

}
