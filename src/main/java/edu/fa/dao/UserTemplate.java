package edu.fa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import edu.fa.model.Users;

@Component
public class UserTemplate {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public Users checkLogin(Users user) {
		String query = "SELECT * FROM namnv25.Users WHERE userName = ? AND password = ?";
		return this.jdbcTemplate.queryForObject(query, new Object[] {user.getUserName(),user.getPassword()}, new UsersMapper());
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
	
	public static final class UsersMapper implements RowMapper<Users>{

		@Override
		public Users mapRow(ResultSet result, int arg1) throws SQLException {
			return new Users(result.getString("userName"), result.getString("password"));
		}
		
	}
	
}
