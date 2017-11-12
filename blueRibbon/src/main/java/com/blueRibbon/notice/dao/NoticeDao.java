package com.blueRibbon.notice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blueRibbon.notice.model.Notice;

public interface NoticeDao extends JpaRepository<Notice, Long> {

}
