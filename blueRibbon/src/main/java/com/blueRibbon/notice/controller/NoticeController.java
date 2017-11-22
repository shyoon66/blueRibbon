package com.blueRibbon.notice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blueRibbon.notice.dao.NoticeDao;
import com.blueRibbon.notice.model.Notice;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired
	private NoticeDao noticeDao;
	
	@RequestMapping("/list")
	public String list(Model model, Pageable pageable) throws Exception {
		logger.debug("@@@@@@@@@@@@@@@@@@@@@@@@ pageable = {}", new PageRequest(0, 10));
		Page<Notice> postPage = noticeDao.findAll(new PageRequest(0, 10));
		//logger.debug("@@@@@@@@@@@@@@@@@@@@@@@@ postPage = {}", postPage);
		model.addAttribute("postPage", postPage.getContent());
		logger.debug("@@@@@@@@@@@@@@@@@@@@@@@@ postPage.getContent = {}", postPage.getContent());
		logger.debug("@@@@@@@@@@@@@@@@@@@@@@@@ model = {}", model);
		
		//model.addAttribute("list", noticeDao.findAll());
		return "/notice/notice";
	}
}
