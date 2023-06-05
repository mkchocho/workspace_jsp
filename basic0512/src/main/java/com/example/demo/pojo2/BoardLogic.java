package com.example.demo.pojo2;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class BoardLogic {

	Logger logger = Logger.getLogger(BoardLogic.class);
	private BoardDao boardDao = new BoardDao();
	public List<Map<String, Object>> boardList(Map<String, Object> pMap) {
		logger.info("boardList"); // 시간과 클래스명, 라인번호 
		List<Map<String, Object>> bList = null;
		bList = boardDao.boardList(pMap); // 조회결과가 없더라도 myBatis레이어에서 주입 
		return bList;
	}

}