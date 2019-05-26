package edu.fa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import edu.fa.model.Student;

@Component
public class StudentJdbcDaoSupport extends JdbcDaoSupport {

	public void insertStudent(Student student) {

		String query = "insert into namnv25.student values(" + student.getId() + ",'" + student.getName() + "','"
				+ student.getLocation() + "')";

		this.getJdbcTemplate().execute(query);

	}

	public void deleteStudent() {

		String query = "DELETE FROM namnv25.student";

		this.getJdbcTemplate().execute(query);

	}

	public Student getStudentById(int id) {

		String query = "SELECT * FROM namnv25.student WHERE id = ?";

		return this.getJdbcTemplate().queryForObject(query, new Object[] { id }, new StudentMapper());

	}

	public static final class StudentMapper implements RowMapper<Student> {

		@Override
		public Student mapRow(ResultSet resultSet, int arg1) throws SQLException {
			return new Student(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("location"));
		}

	}

}
