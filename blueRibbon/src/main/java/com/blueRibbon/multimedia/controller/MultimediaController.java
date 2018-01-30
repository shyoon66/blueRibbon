package com.blueRibbon.multimedia.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blueRibbon.common.service.CommonService;
import com.blueRibbon.multimedia.dao.MultimediaDao;
import com.blueRibbon.multimedia.model.Multimedia;

@Controller
@RequestMapping("/multimedia")
public class MultimediaController {
	
	@Autowired
	CommonService commonService;
	
	@Autowired
	MultimediaDao multimediaDao;
	
	@Value("${multimediaPage.size}")
	private int multimediaPageSize;
	
	private static final Logger logger = LoggerFactory.getLogger(MultimediaController.class);
	
	@RequestMapping("/blueRibbonPhotoList")
	public String noticeList(Model model, Pageable pageable) throws Exception {
		Page<Multimedia> postPage = multimediaDao.findAll(pageable);
		model.addAttribute("view", commonService.getList(postPage, pageable, multimediaPageSize));
		return "/multimedia/blueRibbonPhotoList";
	}
	
}
