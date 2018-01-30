package com.blueRibbon.multimedia.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.blueRibbon.multimedia.model.Multimedia;
import com.blueRibbon.notice.model.Notice;

public interface MultimediaDao extends JpaRepository<Multimedia, Integer> {

	Page<Notice> findByTitleContainingOrContentsContaining(String search_contents1, String search_contents2, Pageable pageable);
	
	//@Query(value = "select n.notice_id, n.title, n.contents, n.user_id, n.create_dt from tb_notice n where n.title like %?1%")
	Page<Notice> findByTitleContaining(String search_contents, Pageable pageable);
	
	Page<Notice> findByContentsContaining(String search_contents, Pageable pageable);
}
