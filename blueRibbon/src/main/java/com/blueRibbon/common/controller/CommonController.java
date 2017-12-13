package com.blueRibbon.common.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

	@RequestMapping("/getTempImage")
	public void getTempImage(Model model, String div, String fileNm, HttpServletResponse response) throws Exception {
		commonService.getTempImage(div, fileNm, response);
	}
}
