package com.programmingfree.springservice.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.programmingfree.springservice.domain.FileProperties;
import com.programmingfree.springservice.domain.User;
import com.programmingfree.springservice.domain.Users;

@Controller
public class ListUsersController {

	//@RequestMapping(value = "/listUsers", method = RequestMethod.GET,headers="Accept=application/json")
	@RequestMapping("/listUsers")
	public ModelAndView listUsers() {
		RestTemplate restTemplate = new RestTemplate();
		String url="http://localhost:8080/SpringServiceExample/service/user/";    
		List<LinkedHashMap> users=restTemplate.getForObject(url, List.class);
		return new ModelAndView("listUsers", "users", users);
	}
	@RequestMapping("/listUsers/xml")
	public ModelAndView listUsers2() {
		RestTemplate restTemplate = new RestTemplate();
		String url="http://localhost:8080/SpringServiceExample/service/user/xml";  
		System.out.println("1253-1");
		Users users = restTemplate.getForObject(url, Users.class);
		List users2 = users.getUsers();
		System.out.println("1253-2");
		return new ModelAndView("listUsers", "users", users2);
	}

	@RequestMapping("/dispUser/{userid}")
	public ModelAndView dispUser(@PathVariable("userid") int userid) {
		RestTemplate restTemplate = new RestTemplate();
		String url="http://localhost:8080/SpringServiceExample/service/user/json/{userid}";
		User user=restTemplate.getForObject(url, User.class,userid);
		return new ModelAndView("dispUser", "user", user);
	}

	@RequestMapping("/dispUser/xml/{userid}")
	public ModelAndView dispUser2(@PathVariable("userid") int userid) {
		RestTemplate restTemplate = new RestTemplate();
		String url="http://localhost:8080/SpringServiceExample/service/user/xml/{userid}";
		User user=restTemplate.getForObject(url, User.class, userid);
		//List<LinkedHashMap> users = restTemplate.getForObject(url, List.class);
		System.out.println("1253-2");
		return new ModelAndView("dispUser", "user", user);

	}	

	@RequestMapping(value = "/userEntry", method = RequestMethod.GET)
	public ModelAndView userEntry() {
		// "command" is a Spring MVC keyword needed if you use <form:form> tags
		System.out.println("0443-1");
		return new ModelAndView("userEntry", "command", new User());
	}

	@RequestMapping(value = "/fileEntry", method = RequestMethod.GET)
	public ModelAndView fileEntry() {
		// "command" is a Spring MVC keyword needed if you use <form:form> tags
		System.out.println("1544-1");
		return new ModelAndView("fileEntry", "command", new FileProperties());
	}
}

