package com.blueRibbon.notice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blueRibbon.notice.dao.NoticeDao;
import com.blueRibbon.notice.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private NoticeDao noticeDao;
	
	@RequestMapping("/list")
	public String list(Model model, Pageable pageable) throws Exception {
		model.addAttribute("view", noticeService.getNoticeList(pageable));		
		return "/notice/notice";
	}
}
