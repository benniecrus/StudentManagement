package edu.fa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.fa.model.Users;
import edu.fa.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value= {"/login"},method=RequestMethod.POST)
	public ModelAndView helloWorld(@ModelAttribute("login") Users user) {
		Users userData = userService.checkLogin(user);
		if(userData!=null) {
			return new ModelAndView("index","userData",userData);
		}else {
			return new ModelAndView("login", "message", "Login Fail!");
		}
	}
}
