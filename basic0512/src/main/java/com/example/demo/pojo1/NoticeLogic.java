package com.example.demo.pojo1;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

//나는 화면이 없이도 테스트가 가능하다 - MVC패턴
public class NoticeLogic {
	Logger logger = Logger.getLogger(NoticeLogic.class);

	public List<Map<String, Object>> noticeList(Map<String, Object> pMap) {
		logger.info("noticeList");
		return null;
	}

	public int noticeInsert(Map<String, Object> pMap) {
		logger.info("noticeInsert");
		return 0;
	}

	public int noticeUpdate(Map<String, Object> pMap) {
		logger.info("noticeUpdate");
		return 0;
	}

	public int noticeDelete(Map<String, Object> pMap) {
		logger.info("noticeDelete");
		return 0;
	}
	
}
