package com.blueRibbon.multimedia.model;

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
@Table(name = "tb_multimedia")
public class Multimedia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int multimediaId;
	
	@Column(name = "kind", length = 1)
	private String kind;
	
	@Column(name = "title", length = 100)
	private String title;
	
	@Column(name = "contents", length = 5000)
	private String contents;
	
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "create_dt", insertable = false)
	@Temporal(TemporalType.DATE)
	private Date createDt;
	
	public Multimedia() {}

	public int getMultimediaId() {
		return multimediaId;
	}

	public void setMultimediaId(int multimediaId) {
		this.multimediaId = multimediaId;
	}
	
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.title = kind;
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
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}
	
}
