package com.blueRibbon.notice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_notice_file")
public class NoticeFile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int noticeFileId;
	
	@Column(name = "notice_id")
	private int noticeId;
	
	@Column(name = "org_file_nm", length = 100)
	private String orgFileNm;
	
	@Column(name = "save_file_nm", length = 200)
	private String saveFileNm;
	
	@Column(name = "file_path", length = 500)
	private String filePath;
	
	@Column(name = "file_extension", length = 50)
	private String fileExtension;
	
	@Column(name = "create_dt", insertable = false)
	private Date createDt;
	
	public NoticeFile() {}

	public int getNoticeFileId() {
		return noticeFileId;
	}

	public void setNoticeFileId(int noticeFileId) {
		this.noticeFileId = noticeFileId;
	}

	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	public String getOrgFileNm() {
		return orgFileNm;
	}

	public void setOrgFileNm(String orgFileNm) {
		this.orgFileNm = orgFileNm;
	}

	public String getSaveFileNm() {
		return saveFileNm;
	}

	public void setSaveFileNm(String saveFileNm) {
		this.saveFileNm = saveFileNm;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}
	
}
