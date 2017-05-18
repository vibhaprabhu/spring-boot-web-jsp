package com.springboot.controller;

import java.util.Date;
import java.util.Map;

import com.springboot.dao.UserDao;
import com.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {

	// inject via application.properties
	@Value("${welcome.message}")
	private String message;

	@Autowired
	private UserDao userDao;

	@RequestMapping("/welcome")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "welcome";
	}

	@RequestMapping("/addUser")
	public String saveUser(Map<String, Object> model, @RequestParam("name") String name) throws Throwable {
		Date date = new Date();
		long id = date.getTime();
		System.out.println("Name="+name);
		User user = new User(id+"", name, "Test");
		userDao.saveUserDetails(user);
		System.out.println("User saved successfully....");
		model.put("userName", name);
		return "userAdditionSuccess";
	}

}