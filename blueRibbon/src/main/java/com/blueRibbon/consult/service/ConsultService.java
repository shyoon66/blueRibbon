package com.blueRibbon.consult.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.blueRibbon.notice.dao.NoticeDao;
import com.blueRibbon.notice.model.Notice;

@Service
@Transactional
public class ConsultService {

	private static final Logger logger = LoggerFactory.getLogger(ConsultService.class);

}
