package com.blueRibbon.common.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.blueRibbon.notice.model.NoticeFile;

@Service
@Transactional
public class CommonService {
	
	@Value("${notice.path}")
	private String noticePath;
	
	private static final Logger logger = LoggerFactory.getLogger(CommonService.class);
	
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
}
