package com.blueRibbon.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.blueRibbon.login.model.KakaoUser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class KakaoLogin {
	
	private static final Logger logger = LoggerFactory.getLogger(KakaoLogin.class);
	
	public static JsonNode getAccessToken(String autorize_code) {
		final String RequestUrl = "https://kauth.kakao.com/oauth/token";

		final List<NameValuePair> postParams = new ArrayList<NameValuePair>();
		postParams.add(new BasicNameValuePair("grant_type", "authorization_code"));
		postParams.add(new BasicNameValuePair("client_id", "099903da7a7fee19ad2e33d79a52e614")); // REST API KEY
		postParams.add(new BasicNameValuePair("redirect_uri", "http://localhost:8080/login/kakaologin")); // 리다이렉트 URI
		postParams.add(new BasicNameValuePair("code", autorize_code)); // 로그인 과정중 얻은 code 값

		final HttpClient client = HttpClientBuilder.create().build();
		final HttpPost post = new HttpPost(RequestUrl);
		JsonNode returnNode = null;

		try {
			post.setEntity(new UrlEncodedFormEntity(postParams));
			final HttpResponse response = client.execute(post);
			final int responseCode = response.getStatusLine().getStatusCode();

			logger.info("\nSending 'POST' request to URL : " + RequestUrl);
			logger.info("Post parameters : " + postParams);
			logger.info("Response Code : " + responseCode);

			// JSON 형태 반환값 처리
			ObjectMapper mapper = new ObjectMapper();
			returnNode = mapper.readTree(response.getEntity().getContent());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// clear resources
		}

		return returnNode;

	}

	public static JsonNode getKakaoUserInfo(String autorize_code) throws Exception {
		final String RequestUrl = "https://kapi.kakao.com/v1/user/me";
		final HttpClient client = HttpClientBuilder.create().build();
		final HttpPost post = new HttpPost(RequestUrl);

		// add header
		post.addHeader("Authorization", "Bearer " + autorize_code);

		JsonNode returnNode = null;

		try {
			final HttpResponse response = client.execute(post);
			final int responseCode = response.getStatusLine().getStatusCode();

			logger.info("\nSending 'POST' request to URL : " + RequestUrl);
			logger.info("Response Code : " + responseCode);

			// JSON 형태 반환값 처리
			ObjectMapper mapper = new ObjectMapper();
			returnNode = mapper.readTree(response.getEntity().getContent());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new Exception("로그인에 실패 했습니다.");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			throw new Exception("로그인에 실패 했습니다.");
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception("로그인에 실패 했습니다.");
		} finally {
			// clear resources
		}
		
		return returnNode;
	}

	public static KakaoUser changeData(JsonNode userInfo) {
		KakaoUser kakaoUser = new KakaoUser();

		kakaoUser.setUserId(userInfo.path("id").asText()); // id -> vo 넣기

		if(userInfo.path("kaccount_email_verified").asText().equals("true")) { // 이메일 받기 허용 한 경우
			kakaoUser.setEmail(userInfo.path("kaccount_email").asText());
			//vo.setUser_email(userInfo.path("kaccount_email").asText()); // email -> vo 넣기
		} else { // 이메일 거부 할 경우 코드 추후 개발

		}

		JsonNode properties = userInfo.path("properties"); // 추가정보 받아오기
		
		if(properties.has("nickname")) {
			kakaoUser.setNickname(properties.path("nickname").asText());
		}
		
		if(properties.has("profile_image")) {
			kakaoUser.setProfileImage(properties.path("profile_image").asText());
		}
		
		if(properties.has("thumbnail_image")) {
			kakaoUser.setThumbnailImage(properties.path("thumbnail_image").asText());
		}		
			
		return kakaoUser;
	}
	
}