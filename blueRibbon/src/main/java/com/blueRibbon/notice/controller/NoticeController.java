package com.blueRibbon.notice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
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
	
	@RequestMapping("/")
	public String notice(Model model, @PageableDefault(sort = {"create_dt"}, direction = Direction.DESC, size = 20) Pageable pageable) throws Exception {
		Page<Notice> postPage = noticeDao.findAll(pageable);
		model.addAttribute("list", postPage);
		return "/notice/notice";
	}
}
