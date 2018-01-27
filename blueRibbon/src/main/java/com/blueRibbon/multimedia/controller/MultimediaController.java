package com.blueRibbon.multimedia.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/multimedia")
public class MultimediaController {
	
	private static final Logger logger = LoggerFactory.getLogger(MultimediaController.class);
	
	@RequestMapping("/blueRibbonPhotoList")
	public String noticeList(Model model, Pageable pageable) throws Exception {
		return "/multimedia/blueRibbonPhotoList";
	}
	
}
