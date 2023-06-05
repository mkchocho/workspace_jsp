package com.example.demo.pojo2;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class BoardDao {
	Logger logger = Logger.getLogger(BoardDao.class);
	//myBatis 레이어 코드 추가됨
	
	public List<Map<String, Object>> boardList(Map<String, Object> pMap) {
		logger.info("boardList ==>"+pMap);//{키=값, 키2=값2,...}
		return null;
	}

}
