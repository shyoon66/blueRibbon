package com.blueRibbon.login.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blueRibbon.login.model.KakaoUser;

public interface KakaoLoginDao extends JpaRepository<KakaoUser, Integer> {

}
