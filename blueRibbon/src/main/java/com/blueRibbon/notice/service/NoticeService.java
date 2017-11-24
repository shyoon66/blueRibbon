package com.blueRibbon.notice.service;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.blueRibbon.notice.controller.NoticeController;
import com.blueRibbon.notice.dao.NoticeDao;
import com.blueRibbon.notice.model.Notice;

@Service
@Transactional
public class NoticeService {
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired
	private NoticeDao noticeDao;
	
	@Value("${pagenum}")
	private int pagenum;
	
	public Map<String, Object> getNoticeList(Pageable pageable) throws Exception {
		Page<Notice> postPage = noticeDao.findAll(pageable);
		Map<String, Object> noticeMap = new HashMap<String, Object>();
		noticeMap.put("list", postPage.getContent());
		noticeMap.put("page", postPage.getNumber());
		noticeMap.put("numOfElements", postPage.getNumberOfElements());
		noticeMap.put("pagenum", pagenum);
		noticeMap.put("divNum", postPage.getNumber() / pagenum);
		noticeMap.put("totalPages", postPage.getTotalPages());
		noticeMap.putAll(getstartAndEndPageNum(postPage.getNumber() + 1, postPage.getTotalPages()));
	
		return noticeMap;
	}
	
	private Map<String, Integer> getstartAndEndPageNum(int page, int totalPage) throws Exception {
		int div = page / pagenum;
		int startPage = 0;
		int endPage = 0;
		Map<String, Integer> pageMap = new HashMap<String, Integer>();
		
		if(totalPage <= pagenum) {
			startPage = page - (page - 1);
			endPage = page;
		} else if(page - (pagenum * div) == 0) {
			if((div - 1) == 0) {
				startPage = page - (page - 1);
			} else {
				startPage = page - (pagenum - 1);
			}
			
			endPage = page;
		} else {
			startPage = pagenum * div + 1;
			endPage = pagenum * (div + 1);
			
			if(totalPage <= endPage) {
				endPage = totalPage;
			}
		}
		
		pageMap.put("startPage", startPage);
		pageMap.put("endPage", endPage);
		
		return pageMap;
	}
}
