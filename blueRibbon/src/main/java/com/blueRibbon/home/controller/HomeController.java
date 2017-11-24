package com.blueRibbon.home.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blueRibbon.notice.controller.NoticeController;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@Value("${pagenum}")
	private int pagenum;

	@RequestMapping("/")
	public String home(Model model) throws Exception {
		model.addAttribute("pagenum", pagenum);
		return "home";
	}
}
