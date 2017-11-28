package com.blueRibbon.notice.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value = "/insertProc.json", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> noticeInsertProc(Model model, @ModelAttribute Notice notice) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("test", "test");
		model.addAttribute("test", "test");
		noticeService.insertNotice(notice);
		logger.debug("@@@@@@@@@@@@@@@@ model = " + model);
		return map;
	}
	
	@RequestMapping("/update")
	public String noticeUpdate(Model model, int noticeId) throws Exception {
		model.addAttribute("view", noticeDao.findOne(noticeId));
		return "/notice/noticeUpdate";
	}
	
	@RequestMapping(value = "/deleteProc.json", method = RequestMethod.POST)
	public void noticeDeleteProc(Model model, int noticeId) throws Exception {
		noticeService.deleteNotice(model, noticeId);
	}
}
