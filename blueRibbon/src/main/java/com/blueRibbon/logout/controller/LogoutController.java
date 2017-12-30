package com.blueRibbon.logout.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blueRibbon.login.service.LoginService;
import com.blueRibbon.logout.service.LogoutService;
import com.blueRibbon.util.KakaoLogout;
import com.fasterxml.jackson.databind.JsonNode;

@Controller
@RequestMapping("/logout")
public class LogoutController {
	
	private static final Logger logger = LoggerFactory.getLogger(LogoutController.class);
	
	@Autowired
	private LogoutService logoutService;
	
	@RequestMapping("/kakao")
	public String logout(Model model, HttpSession session) throws Exception {
		String access_token = (String) session.getAttribute("access_token");
		//JsonNode user_id = KakaoLogout.logout(access_token);
		
		//if(user_id != null) {
			if(KakaoLogout.unlink(access_token) != null) {
				session.removeAttribute("user");
				session.removeAttribute("login_type");
				logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@ 세션 삭제 @@@@@@@@@@@@@@@@@@@@@@@@@@@@");					
			}	
		//}
		
		return "redirect:/";
	}
	
}
