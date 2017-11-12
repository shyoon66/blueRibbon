package com.blueRibbon.home.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blueRibbon.notice.controller.NoticeController;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

	@RequestMapping("/")
	public String home() throws Exception {
		return "home";
	}
}
