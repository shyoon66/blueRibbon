package com.blueRibbon.notice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blueRibbon.notice.dao.NoticeDao;
import com.blueRibbon.notice.model.Notice;
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
	public String noticeList(Model model, Pageable pageable) throws Exception {
		model.addAttribute("view", noticeService.getNoticeList(pageable));		
		return "/notice/noticeList";
	}
	
	@RequestMapping("/view")
	public String noticeView(Model model, int noticeId, Pageable pageable) throws Exception {
		model.addAttribute("view", noticeDao.findOne(noticeId));		
		return "/notice/noticeView";
	}
	
	@RequestMapping("/insert")
	public String noticeInsert(Model model) throws Exception {
		return "/notice/noticeInsert";
	}
	
	@RequestMapping("/insertProc")
	public String noticeInsertProc(Model model, @ModelAttribute Notice notice) throws Exception {
		noticeService.insertNotice(notice);
		return "/notice/noticeInsert";
	}
	
	@RequestMapping("/update")
	public String noticeUpdate(Model model, int noticeId) throws Exception {
		model.addAttribute("view", noticeDao.findOne(noticeId));
		return "/notice/noticeUpdate";
	}
}
