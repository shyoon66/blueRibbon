package com.blueRibbon.notice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_notice")
public class Notice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int noticeId;
	
	@Column(name = "title", length = 100)
	private String title;
	
	@Column(name = "contents", length = 5000)
	private String contents;
	
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "create_dt", insertable = false)
	@Temporal(TemporalType.DATE)
	private Date createDt;
	
	public Notice() {}

	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}
	
}
