package com.blueRibbon.common.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blueRibbon.common.service.CommonService;

@Controller
@RequestMapping("/common")
public class CommonController {
	
	@Autowired
	private CommonService commonService;
	
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);

	@RequestMapping("/getImage")
	public void getImage(Model model, String imagePath, HttpServletResponse response) throws Exception {
		//commonService.getImage(response);
	}
}
