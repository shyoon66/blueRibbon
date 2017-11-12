package com.blueRibbon.notice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_NOTICE")
public class Notice {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long notice_id;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="CONTENTS")
	private String contents;
	
	@Column(name="USER_ID")
	private String user_id;
	
	@Column(name="CREATE_DT")
	private Date create_dt;
	
	public Notice() {}

	public Long getNotice_id() {
		return notice_id;
	}

	public void setNotice_id(Long notice_id) {
		this.notice_id = notice_id;
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

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Date getCreate_dt() {
		return create_dt;
	}

	public void setCreate_dt(Date create_dt) {
		this.create_dt = create_dt;
	}
	
}
