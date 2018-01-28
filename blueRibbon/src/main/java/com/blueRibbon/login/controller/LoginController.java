package com.blueRibbon.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blueRibbon.login.model.KakaoUser;
import com.blueRibbon.login.service.LoginService;
import com.blueRibbon.util.KakaoLogin;
import com.fasterxml.jackson.databind.JsonNode;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/")
	public String kakaoLogin(Model model) throws Exception {	  
	  return "login/login";
	}
	
	@RequestMapping(value = "/kakaologin", produces = "application/json", method = {RequestMethod.GET, RequestMethod.POST})
	public String kakaoLogin(Model model, @RequestParam(value = "code", required = false) String code, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		try {
			if(code != null) {
				JsonNode token = KakaoLogin.getAccessToken(code);
				//logger.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ token = {}", token);
				JsonNode profile = KakaoLogin.getKakaoUserInfo(token.path("access_token").toString());
				//logger.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ user_profile = {}", profile);
				KakaoUser kakaoUser = KakaoLogin.changeData(profile);
				session.setAttribute("access_token", token.path("access_token").toString());
				session.setAttribute("user", kakaoUser);
				session.setAttribute("login_type", "kakao");
				loginService.insertKakaoUser(kakaoUser);				
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}	
		
		return "redirect:/";
	}
	
}
