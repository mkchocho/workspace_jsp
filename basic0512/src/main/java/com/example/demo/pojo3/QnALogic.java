package com.example.demo.pojo3;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
//모델계층 - 업무에 대한 선택, 결정, 기준
//업무 내용에 따라서 QnADao에 있는 여러개의 메소드를 하나의 메소드 안에서 호출할 수 있다.
//이것이 XXXLogic 클래스가 필요한 이유이다.
public class QnALogic {
	Logger logger = Logger.getLogger(QnALogic.class);
	private QnADao qnaDao = new QnADao();
	public List<Map<String, Object>> qnaList(Map<String, Object> pMap) {
		logger.info("qnaList");
		List<Map<String,Object>> qList = null;
		qList = qnaDao.qnaList(pMap);
		return qList;
	}
	
	

}
