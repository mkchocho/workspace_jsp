package com.example.demo.pojo3;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class QnADao {
	Logger logger = Logger.getLogger(QnADao.class);

	public List<Map<String, Object>> qnaList(Map<String, Object> pMap) {
		logger.info("qnaList");
		List<Map<String,Object>> qList =null;
		try {
			//insert here
		} catch (Exception e) {
			// TODO: handle exception
		}
		return qList;
	}
}
