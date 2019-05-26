package edu.fa.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.fa.model.Users;

@Component
public class UserDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public Users checkLogin(Users user) {
		
		String query = "FROM Users WHERE userName='"+user.getUserName()+"' AND password='"+user.getPassword()+"'";
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Users> users = session.createQuery(query).list();
		if(users.size()>0)
			return users.get(0);
		
		return null;
	}
}
