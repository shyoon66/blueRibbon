package com.blueRibbon.notice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blueRibbon.notice.dao.NoticeDao;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired
	private NoticeDao noticeDao;

	@RequestMapping("/")
	public String notice(Model model) throws Exception {
		model.addAttribute("list", noticeDao.findAll());
		return "/notice/notice";
	}
	
/*	@RequestMapping("/list")
	public List<Notice> list(Model model) throws Exception {
		List<Notice> noticeList = noticeDao.findAll();
		return noticeList;
	}*/
}
