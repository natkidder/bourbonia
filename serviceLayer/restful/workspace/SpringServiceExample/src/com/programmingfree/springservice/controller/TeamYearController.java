package com.programmingfree.springservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.programmingfree.springservice.domain.TeamYear;
import com.programmingfree.springservice.domain.User;

@Controller
public class TeamYearController {

	@RequestMapping(value = "/teamYearEntry", method = RequestMethod.GET)
	public ModelAndView userEntry() {
		// "command" is a Spring MVC keyword needed if you use <form:form> tags
		System.out.println("0710-1");
		return new ModelAndView("teamYearEntry", "command", new TeamYear());
	}
}
