package com.goodee.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class NoticeLogic {
	Logger logger = Logger.getLogger(NoticeLogic.class);
	private NoticeDao noticeDao = new NoticeDao();

	public List<Map<String, Object>> noticeList(Map<String, Object> pMap) {// select -> 유지 -> forward
		logger.info("noticeList");
		List<Map<String, Object>> nList = null;
		nList = noticeDao.noticeList(pMap);
		if (nList == null) {// 그래서 나는 널 체크를 한다 - 간섭을 좀 하려구
			logger.info("nList==null일때");// select한 결과가 1건도 없으면 이리로 온다.
			// 조회결과가 만일 없어서 null이 넘어가는 것을 방어하자
			nList = new ArrayList<>();
		}
		return nList;// 왜냐하면 SELECT한 결과값이 존재하니
	}// end of noticeList

	public int noticeInsert(Map<String, Object> pMap) {
		logger.info("noticeInsert");
		int result = 0;
		result = noticeDao.noticeInsert(pMap);
		return result;
	}// end of noticeInsert

}
