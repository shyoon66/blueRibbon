package com.blueRibbon.common.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.blueRibbon.login.model.KakaoUser;
import com.blueRibbon.notice.model.NoticeFile;

@Service
@Transactional
public class CommonService {
	
	@Value("${notice.path}")
	private String noticePath;
	
	private static final Logger logger = LoggerFactory.getLogger(CommonService.class);
	
	@SuppressWarnings("rawtypes")
	public Map<String, Object> getList(Page postPage, Pageable pageable, int pageSize) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", postPage.getContent());
		map.put("page", postPage.getNumber());
		map.put("numOfElements", postPage.getNumberOfElements());
		map.put("pageSize", pageSize);
		map.put("divNum", postPage.getNumber() / pageSize);
		map.put("totalPages", postPage.getTotalPages());
		map.putAll(getStartAndEndPageNum(postPage.getNumber() + 1, postPage.getTotalPages(), pageSize));

		return map;
	}
	
	private Map<String, Integer> getStartAndEndPageNum(int page, int totalPage, int pageSize) throws Exception {
		int div = page / pageSize;
		int startPage = 0;
		int endPage = 0;
		Map<String, Integer> pageMap = new HashMap<String, Integer>();

		if (totalPage == 0) {
			startPage = 1;
			endPage = 1;
		} else {
			if (totalPage <= pageSize) {
				startPage = page - (page - 1);
				endPage = totalPage;
			} else if (page - (pageSize * div) == 0) {
				if ((div - 1) == 0) {
					startPage = page - (page - 1);
				} else {
					startPage = page - (pageSize - 1);
				}

				endPage = page;
			} else {
				startPage = pageSize * div + 1;
				endPage = pageSize * (div + 1);

				if (totalPage <= endPage) {
					endPage = totalPage;
				}
			}
		}

		pageMap.put("startPage", startPage);
		pageMap.put("endPage", endPage);

		return pageMap;
	}
	
	public void getTempImage(String div, String fileNm, HttpServletResponse response) throws Exception {
		String path = "";
		
		if("notice".equals(div)) {
			path = noticePath;
		}
		
		String filePath = FilenameUtils.concat(path, fileNm);
		String ext = FilenameUtils.getExtension(fileNm);

		BufferedOutputStream out = null;
		InputStream in = null;

		try {
			response.setContentType("image/" + ext);
			response.setHeader("Content-Disposition", "inline;filename=" + fileNm);
			File file = new File(filePath);
			
			if(file.exists()) {
				in = new FileInputStream(file);
				out = new BufferedOutputStream(response.getOutputStream());
				int len;
				byte[] buf = new byte[1024];
				while((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(out != null)	{ out.flush(); }
			if(out != null)	{ out.close(); }
			if(in != null)	{ in.close(); }
		}		
	}
	
    public NoticeFile uploadImageProc(MultipartFile file) throws IOException, IllegalStateException, Exception {   	
    	try {
    		if(file.isEmpty()) {
                throw new Exception("파일이 존재하지 않습니다.");
            }
    		
    		String org_file_nm = file.getOriginalFilename();    		
    		String extension = FilenameUtils.getExtension(org_file_nm);
    		String content_type = file.getContentType();
    		long fileSize = file.getSize();
    		
/*    		Map<String, Object> fileMap = new HashMap<String, Object>();
    		fileMap.put("extension", extension);
    		fileMap.put("content_type", content_type);
    		fileMap.put("fileSize", fileSize);  */  		
    		validateImage(content_type, extension, fileSize);
    		
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
            noticeFile.setFileExtension(extension);
            noticeFile.setFilePath(upload_path);
            
            return noticeFile;
        } catch (IOException ioe) {
            throw new Exception("파일 저장에 실패했습니다. (파일이름 = " + file.getOriginalFilename() + ")", ioe);
        } catch (IllegalStateException ise) {
        	throw new Exception("파일 저장에 실패했습니다. (파일이름 = " + file.getOriginalFilename() + ")", ise);
        } catch(Exception e) {
        	throw new Exception(e.getMessage());
        }
    }
    
    private void validateImage(String content_type, String extension, long fileSize) throws Exception {
    	if(content_type.indexOf("image") < 0) {
    		throw new Exception("사진파일만 업로드 가능합니다.");
    	}
    	
    	if(!"png".equals(extension) && !"jpg".equals(extension) && !"gif".equals(extension)) {
    		throw new Exception("확장자가 png, jpg, gif인 파일만 업로드 가능합니다.");
    	}
    	
    	if((fileSize / 1024 / 1024) > 10) {
    		throw new Exception("이미지 업로드는 10MB까지 가능합니다.");
    	}
    }
    
	public Map<String, String> getUser(Object user) throws Exception {
		Map<String, String> userMap = new HashMap<String, String>();
		
		if(user instanceof KakaoUser) {
			KakaoUser kakaoUser = (KakaoUser) user;
			userMap.put("userId", kakaoUser.getUserId());
			userMap.put("userName", kakaoUser.getNickname());
			userMap.put("authority", kakaoUser.getAuthority());
		}

		return userMap;
	}
}
