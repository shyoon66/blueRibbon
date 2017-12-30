package com.blueRibbon.login.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_kakao_user_info")
public class KakaoUser {
	
	@Id
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "nickname")
	private String nickname;
	
	@Column(name = "profile_image")
	private String profileImage;
	
	@Column(name = "thumbnail_image")
	private String thumbnailImage;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "authority")
	private String authority;
	
	@Column(name = "create_dt", insertable = false)
	@Temporal(TemporalType.DATE)
	private Date createDt;
	
	public KakaoUser() {}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	
	public String getThumbnailImage() {
		return thumbnailImage;
	}
	
	public void setThumbnailImage(String thumbnailImage) {
		this.thumbnailImage = thumbnailImage;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}
	
}
