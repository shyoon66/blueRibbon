package com.blueRibbon.notice.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.blueRibbon.notice.dao.NoticeDao;
import com.blueRibbon.notice.model.Notice;
import com.blueRibbon.notice.model.NoticeFile;

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
		
		pageMap.put("startPage", startPage);
		pageMap.put("endPage", endPage);
		
		return pageMap;
	}
	
	public void insertNotice(Notice notice) throws Exception {
		noticeDao.save(notice);
	}
	
	public void deleteNotice(Model model, int noticeId) throws Exception {
		try {
			noticeDao.delete(noticeId);
			model.addAttribute("success", true);
			model.addAttribute("rMsg", "삭제가 성공 했습니다.");
		} catch(Exception e) {
			model.addAttribute("success", false);
			model.addAttribute("rMsg", "삭제가 실패 했습니다.");
		}
	}
	
    public NoticeFile uploadImageProc(MultipartFile file, int noticeId) throws Exception {    	
    	try {
    		if(file.isEmpty()) {
                throw new Exception("파일이 존재하지 않습니다");
            }
            
            String org_file_nm = file.getOriginalFilename();
    		String saveFileNm = System.currentTimeMillis() + "_" + org_file_nm;
    		String upload_path = FilenameUtils.concat(noticePath, saveFileNm);
    		
    		File notice = new File(noticePath);
    		
    		if(!notice.exists()) {
    			notice.mkdir();
    		}
    		
            file.transferTo(new File(upload_path));
            
            NoticeFile noticeFile = new NoticeFile();
            noticeFile.setOrgFileNm(org_file_nm);
            noticeFile.setSaveFileNm(saveFileNm);
            noticeFile.setFileExtension(FilenameUtils.getExtension(org_file_nm));
            
            //noticeDao.save(entity)
            
            return noticeFile;
        } catch (Exception e) {
            throw new Exception("파일 저장에 실패했습니다. (파일이름 = " + file.getOriginalFilename() + ")", e);
        }
    }
    
}
