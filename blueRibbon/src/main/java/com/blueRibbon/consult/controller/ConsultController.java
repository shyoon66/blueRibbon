package com.blueRibbon.consult.controller;

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
import com.blueRibbon.consult.dao.ConsultDao;
import com.blueRibbon.consult.model.RecruitmentSchedule;
import com.blueRibbon.consult.service.ConsultService;
import com.blueRibbon.notice.model.Notice;

@Controller
@RequestMapping("/consult")
public class ConsultController {
	
	@Autowired
	private ConsultService consultService;
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private ConsultDao consultDao;
	
	@Value("${page.size}")
	private int pageSize;
	
	private static final Logger logger = LoggerFactory.getLogger(ConsultController.class);
	
	@RequestMapping("/faq")
	public String home(Model model) throws Exception {		
		return "consult/faq";
	}
	
	@RequestMapping("/recruitmentScheduleList")
	public String recruitmentScheduleList(Model model, Pageable pageable) throws Exception {
		Page<RecruitmentSchedule> postPage = consultDao.findAll(pageable);
		model.addAttribute("view", commonService.getList(postPage, pageable, pageSize));
		return "consult/recruitmentScheduleList";
	}
}
