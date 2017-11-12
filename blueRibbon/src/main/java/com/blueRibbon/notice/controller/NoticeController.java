package com.blueRibbon.notice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blueRibbon.notice.dao.NoticeDao;
import com.blueRibbon.notice.model.Notice;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	@Autowired
	private NoticeDao noticeDao;

	@RequestMapping("/")
	public String notice() throws Exception {
		return "/notice/notice";
	}
	
	@RequestMapping("/list")
	public List<Notice> list(Model model) throws Exception {
		List<Notice> noticeList = noticeDao.findAll();
		return noticeList;
	}
}
