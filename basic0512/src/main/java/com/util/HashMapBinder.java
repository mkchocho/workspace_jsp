package com.util;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

//내 안에는 요청객체가 없다
//공통코드를 뽑아낸다 - 초보는 아니다
//반복되는 코드를 찾아내서...
//코드의 양은 많아지더라도 복잡도는 증가하지 않게 코딩하기 
//재사용이 높은 코드를 작성 하려면 인터페이스 혹은 추상클래스 중심의 코딩을 전개하기
//상속은 재사용을 위한 모범답안은 아니다 - 왜냐면 결합도가 높아서, 의존적이다

public class HashMapBinder {
	Logger logger = Logger.getLogger(HashMapBinder.class);
	HttpServletRequest req = null;
	public HashMapBinder() {} //디폴트 생성자
	//생성자의 파라미터를 통해서 서블릿 클래스가 톰캣 서버로부터 주입받은
	//주소번지를 인스턴스화 할 때 생성자를 호출 하니까 그 생성자의
	//파라미터로 서블릿이 쥐고 있는 요청객체의 원본을 받아온다.
	public HashMapBinder(HttpServletRequest req) {
		this.req = req;
	}


	public void bind(Map<String,Object> pMap) {
		pMap.clear();//이미 쥐고 있는 데이터가 있으면 비워라 
		//s가 붙으면 복수형 - 자루안에 데이터가 존재하는지 유무를 반환하는 메소드 - hasMoreElement
		Enumeration<String> en = req.getParameterNames(); //mem_id, mem_pw, mem_name
		while(en.hasMoreElements()) {
			String key = en.nextElement();//mem_id, mem_pw, mem_name, gubun, keyword
			logger.info(req.getParameter(key));//한글 깨짐을 출력한 코드
			pMap.put(key, req.getParameter(key));//한글처리 끝 HangulConversion.toUTF() - POST방식 
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
