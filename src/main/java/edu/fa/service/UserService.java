package edu.fa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fa.dao.UserDao;
import edu.fa.dao.UserTemplate;
import edu.fa.model.Users;
import edu.fa.repository.UsersRepository;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private UserTemplate userTemplate;
	
	public Users checkLogin(Users user) {
//		return userDao.checkLogin(user);
		return usersRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword());
//		return userTemplate.checkLogin(user);
		
	}
}
