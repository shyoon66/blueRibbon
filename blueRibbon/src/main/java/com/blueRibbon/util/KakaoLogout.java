package com.blueRibbon.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class KakaoLogout {
	
	private static final Logger logger = LoggerFactory.getLogger(KakaoLogout.class);

	public static JsonNode logout(String access_token) throws Exception {
		final String RequestUrl = "https://kapi.kakao.com/v1/user/logout";
		final HttpClient client = HttpClientBuilder.create().build();
		final HttpPost post = new HttpPost(RequestUrl);

		// add header
		post.addHeader("Authorization", "Bearer " + access_token);

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
			throw new Exception("로그아웃에 실패 했습니다.");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			throw new Exception("로그아웃에 실패 했습니다.");
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception("로그아웃에 실패 했습니다.");
		} finally {
			// clear resources
		}
		
		return returnNode;
	}
	
	public static JsonNode unlink(String access_token) throws Exception {
		final String RequestUrl = "https://kapi.kakao.com/v1/user/unlink";
		final HttpClient client = HttpClientBuilder.create().build();
		final HttpPost post = new HttpPost(RequestUrl);
		
		// add header
		post.addHeader("Authorization", "Bearer " + access_token);
		
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
			throw new Exception("로그아웃에 실패 했습니다.");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			throw new Exception("로그아웃에 실패 했습니다.");
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception("로그아웃에 실패 했습니다.");
		} finally {
			// clear resources
		}
		
		return returnNode;
	}
	
}