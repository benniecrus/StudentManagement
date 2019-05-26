package edu.fa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import edu.fa.model.Student;

@Component
public class StudentJdbcTemplateDao {
	
	
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;
	
	public void insertStudent(Student student) {
		
		
		String query = "insert into namnv25.student values(" + student.getId() + ",'" + student.getName() + "','"
				+ student.getLocation() + "')";
		
		jdbcTemplate.execute(query);
		
	}

	public void deleteStudent() {
		
		String query = "DELETE FROM namnv25.student";
		
		jdbcTemplate.execute(query);
		
	}
	
	public Student getStudentById(int id) {
		
		String query = "SELECT * FROM namnv25.student WHERE id = ?";
		
		return jdbcTemplate.queryForObject(query, new Object[] {id}, new StudentMapper());
		
	}
	
	public int countStudent() {
		
		String query = "SELECT COUNT(*) FROM namnv25.student";
		
		return jdbcTemplate.queryForObject(query, Integer.class);
		
	}
	
	public List<Student> getAllStudent() {
		String query = "SELECT * FROM namnv25.student";
		
		return jdbcTemplate.query(query, new StudentMapper());
		
	}
	


	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
	}
	
	public static final class StudentMapper implements RowMapper<Student>{

		@Override
		public Student mapRow(ResultSet resultSet, int arg1) throws SQLException {
			return new Student(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("location"));
		}
		
	}

}
