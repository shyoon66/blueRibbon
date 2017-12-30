package com.blueRibbon.logout.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LogoutService {
	
	private static final Logger logger = LoggerFactory.getLogger(LogoutService.class);
	
	public void kakaoLogout() throws Exception {

	}
	
}
