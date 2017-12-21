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
import org.springframework.ui.Model;

import com.blueRibbon.notice.dao.NoticeDao;
import com.blueRibbon.notice.model.Notice;

@Service
@Transactional
public class NoticeService {
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeService.class);
	
	@Autowired
	private NoticeDao noticeDao;
	
	@Value("${page.size}")
	private int pageSize;
	
	@Value("${notice.path}")
	private String noticePath;
	
	public Map<String, Object> getNoticeList(Pageable pageable) throws Exception {
		Page<Notice> postPage = noticeDao.findAll(pageable);
		Map<String, Object> noticeMap = new HashMap<String, Object>();
		noticeMap.put("list", postPage.getContent());
		noticeMap.put("page", postPage.getNumber());
		noticeMap.put("numOfElements", postPage.getNumberOfElements());
		noticeMap.put("pageSize", pageSize);
		noticeMap.put("divNum", postPage.getNumber() / pageSize);
		noticeMap.put("totalPages", postPage.getTotalPages());
		noticeMap.putAll(getStartAndEndPageNum(postPage.getNumber() + 1, postPage.getTotalPages()));
	
		return noticeMap;
	}
	
	private Map<String, Integer> getStartAndEndPageNum(int page, int totalPage) throws Exception {
		int div = page / pageSize;
		int startPage = 0;
		int endPage = 0;
		Map<String, Integer> pageMap = new HashMap<String, Integer>();
		
		if(totalPage == 0) {
			startPage = 1;
			endPage = 1;
		} else {
			if(totalPage <= pageSize) {
				startPage = page - (page - 1);
				endPage = totalPage;
			} else if(page - (pageSize * div) == 0) {
				if((div - 1) == 0) {
					startPage = page - (page - 1);
				} else {
					startPage = page - (pageSize - 1);
				}
				
				endPage = page;
			} else {
				startPage = pageSize * div + 1;
				endPage = pageSize * (div + 1);
				
				if(totalPage <= endPage) {
					endPage = totalPage;
				}
			}			
		}
		
		pageMap.put("startPage", startPage);
		pageMap.put("endPage", endPage);
		
		return pageMap;
	}
	
	public Notice insertNotice(Notice notice) throws Exception {
		return noticeDao.save(notice);
	}
	
	public Notice updateNotice(Notice notice) throws Exception {
		return noticeDao.save(notice);
	}
	
	public Map<String, Object> deleteNotice(Model model, int noticeId) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("url", String.format("/notice/list?page=0&size=%d&sort=createDt,desc", pageSize));
		
		try {
			noticeDao.delete(noticeId);
			map.put("success", true);
			map.put("msg", "삭제가 성공 했습니다.");
		} catch(IllegalArgumentException e) {
			map.put("success", false);
			map.put("msg", "삭제가 실패 했습니다.");
		}
	
		return map;
	}
	
}
