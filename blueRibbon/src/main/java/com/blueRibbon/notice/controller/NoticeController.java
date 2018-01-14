package com.blueRibbon.notice.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.blueRibbon.common.service.CommonService;
import com.blueRibbon.notice.dao.NoticeDao;
import com.blueRibbon.notice.model.Notice;
import com.blueRibbon.notice.model.NoticeFile;
import com.blueRibbon.notice.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private NoticeDao noticeDao;
	
	@Value("${page.size}")
	private int pageSize;
	
	@RequestMapping("/list")
	public String noticeList(Model model, Pageable pageable) throws Exception {
		model.addAttribute("view", noticeService.getNoticeList(pageable));		
		return "/notice/noticeList";
	}
	
	@RequestMapping("/view")
	public String noticeView(Model model, int noticeId) throws Exception {
		model.addAttribute("view", noticeDao.findOne(noticeId));		
		return "/notice/noticeView";
	}
	
	@RequestMapping("/search")
	public String noticeSearch(Model model, @RequestParam("search") String search, @RequestParam("search_contents") String search_contents, Pageable pageable) throws Exception {
		model.addAttribute("view", noticeService.getSearchNoticeList(search, search_contents, pageable));
		return "/notice/noticeList";
	}
	
	@RequestMapping("/insert")
	public String noticeInsert(Model model, HttpSession session) throws Exception {
		model.addAttribute("user", session.getAttribute("user")); 
		return "/notice/noticeInsert";
	}
	
	@RequestMapping(value = "/insertProc.json", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> noticeInsertProc(Model model, @ModelAttribute Notice notice) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			if(noticeService.insertNotice(notice) != null) {
				map.put("success", true);
				map.put("msg", "등록이 성공 했습니다.");
				map.put("url", String.format("/notice/list?page=0&size=%d&sort=createDt,desc", pageSize));
			} else {
				map.put("success", false);
				map.put("msg", "등록이 실패 했습니다.");
			}	
		} catch(Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("msg", e.getMessage());
		}
		
		return map;
	}
	
	@RequestMapping(value = "/updateProc.json", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> noticeUpdateProc(Model model, @ModelAttribute Notice notice) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			if(noticeService.updateNotice(notice) != null) {
				map.put("success", true);
				map.put("msg", "수정이 성공 했습니다.");
				map.put("url", String.format("/notice/list?page=0&size=%d&sort=createDt,desc", pageSize));
			} else {
				map.put("success", false);
				map.put("msg", "수정이 실패 했습니다.");
			}	
		} catch(Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("msg", e.getMessage());			
		}
		
		return map;
	}
	
	@RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> uploadImage(Model model, @RequestParam("file") MultipartFile file) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			NoticeFile noticeFile = commonService.uploadImageProc(file);
			String url = "/common/getTempImage?div=notice&fileNm=" + noticeFile.getSaveFileNm();
			
			map.put("success", true);
			map.put("url", url);
			map.put("noticeFile", noticeFile);
		} catch(Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("msg", e.getMessage());
		}
	
		return map;
	}
	
	@RequestMapping("/update")
	public String noticeUpdate(Model model, int noticeId) throws Exception {
		model.addAttribute("view", noticeDao.findOne(noticeId));
		return "/notice/noticeUpdate";
	}
	
	@RequestMapping(value = "/deleteProc.json", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> noticeDeleteProc(Model model, int noticeId) throws Exception {
		return noticeService.deleteNotice(model, noticeId);
	}
}
