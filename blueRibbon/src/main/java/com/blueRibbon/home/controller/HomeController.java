package com.blueRibbon.home.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Value("${page.size}")
	private int pageSize;

	@RequestMapping("/")
	public String home(Model model, HttpSession session) throws Exception {
		model.addAttribute("pageSize", pageSize);
		Object userSession = session.getAttribute("user");
		
		logger.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@ user = " + session.getAttribute("user"));
		logger.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@ login_type = " + session.getAttribute("login_type"));
		
		if(userSession != null) {
			model.addAttribute("user", userSession);
			model.addAttribute("login_type", session.getAttribute("login_type"));
		}
		
		return "home";
	}
}
