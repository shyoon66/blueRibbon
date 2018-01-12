package com.blueRibbon.login.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blueRibbon.login.dao.KakaoLoginDao;
import com.blueRibbon.login.model.KakaoUser;

@Service
@Transactional
public class LoginService {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginService.class);
	
	@Autowired
	private KakaoLoginDao kakaoLoginDao;
	
	public KakaoUser insertKakaoUser(KakaoUser kakaoUser) throws Exception {
		String user_id = kakaoUser.getUserId();
		
/*		if("681910979".equals(user_id)) {
			kakaoUser.setAuthority("A");
		}*/
		
		return kakaoLoginDao.save(kakaoUser);
	}
	
}
