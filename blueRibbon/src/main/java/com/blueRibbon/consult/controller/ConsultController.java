package com.blueRibbon.consult.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/consult")
public class ConsultController {
	
	private static final Logger logger = LoggerFactory.getLogger(ConsultController.class);
	
	@RequestMapping("/faq")
	public String home(Model model, HttpSession session) throws Exception {		
		return "consult/faq";
	}
}
