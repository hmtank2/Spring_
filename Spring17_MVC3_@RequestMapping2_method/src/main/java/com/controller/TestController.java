package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

	@RequestMapping(value="/loginForm", 
			method = RequestMethod.GET)
	public String loginForm() {
		System.out.println("loginForm");
		return "/WEB-INF/views/loginForm.jsp";
	}
	@RequestMapping(value="/login", 
			method = RequestMethod.POST)
	public String login() {
		System.out.println("login");
		return "/WEB-INF/views/main.jsp";
	}
}
