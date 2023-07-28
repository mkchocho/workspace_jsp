package com.util;

import java.util.Enumeration;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

public class HashMapBinder {
	Logger logger = Logger.getLogger(HashMapBinder.class);
	HttpServletRequest req = null;
	public HashMapBinder() {} //디폴트 생성자
	public HashMapBinder(HttpServletRequest req) {
		this.req = req;
	}
	//첨부파일이 있을 때 사용자가 입력한 값 청취하기 - 읽어오기
	public void bind(Map<String,Object> pMap) {
		pMap.clear();//이미 쥐고 있는 데이터가 있으면 비워라 
		//s가 붙으면 복수형 - 자루안에 데이터가 존재하는지 유무를 반환하는 메소드 - hasMoreElement
		Enumeration<String> en = req.getParameterNames(); //mem_id, mem_pw, mem_name
		while(en.hasMoreElements()) {
			String key = en.nextElement();//mem_id, mem_pw, mem_name, gubun, keyword
			logger.info(req.getParameter(key));//한글 깨짐을 출력한 코드
			//GET방식의 한글처리 - server.xml -> URIencoding = "utf-8"
			//POST방식의 한글 처리 -> HangulConversion.java -> toUTF
			pMap.put(key, HangulConversion.toUTF(req.getParameter(key)));//한글처리 끝 HangulConversion.toUTF() - POST방식
//			pMap.put(key, req.getParameter(key));//GET방식
		}
	}
}
/*
	아래 코드가  부서관리, 사원관리, 주문관리 마다 필요하다 
	//java collection framework(List,Map)에는 읽기와 쓰기, 담기와 꺼내기에 대한인터페이스를 제공한다.
	//Enumeration은 자료구조에 담는 역할이 아니라 꺼내기와 관련된 메소드를 제공함
	Enumeration<String> en = req.getParameterNames();  Names

	<input type="text" name="mem_id">
	호출 시 req.getParameter("mem_id")
	<input type="text" name="mem_pw">
	req.getParameter("mem_pw")
	<input type="text" name="mem_name">
	req.getParameter("mem_name")



 */
