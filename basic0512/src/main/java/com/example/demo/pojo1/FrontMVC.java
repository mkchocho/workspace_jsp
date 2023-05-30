package com.example.demo.pojo1;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public class FrontMVC extends HttpServlet {
	Logger logger = Logger.getLogger(FrontMVC.class);
	//사용자 정의 메소드
	//아래 메소드를 호출하는 URL패턴은 무엇입니까?
	//http://localhost:9000/notice/noticeList.pj1
	//http://localhost:9000/xxx.pj1
	protected void doService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("doService");
		String uri = req.getRequestURI();
		logger.info(uri);
		StringBuffer url = req.getRequestURL();
		logger.info(url);
		//힌트 - 업무폴더이름으로 가능한가? 아니면 페이지 이름으로 하는게 좋은가?
		//너 전체 조회할 거야?
		if(true) {
		}
		//상세보기를 원해?
		else if(true) {
		}
		//글 등록?
		else if(true) {
		}
		//글 수정?
		else if(true) {
		}
		
	}
	
	//서블릿에서 정의된 메소드를 재정의 하는 것 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doService(req, resp);
	}

	//서블릿에서 정의된 메소드를 재정의 하는 것
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doService(req, resp);
	}
	
}
/*
 * doGet으로 요청이 들어오든지 또는 doPost로 요청이 오든지 모두 doService메소드를 경유하도록 설계 하였다.
 * 메소드 설계는 리턴타입과 파라미터를 포함한다
 * 이때 파라미터로 톰캣 서버로부터 주입받은 request객체와 response객체를 넘겨 받는다 -중요
 * 왜 서블릿이어야 하나? - 요청객체와 응답객체를 받아야 하니까
 * doGet의 파라미터 자리는 바꿀 수 없다 - what? 파라미터 갯수나 타입을 바꿀 수 없다.
 * 왜냐면 메소드 오버라이딩 조건을 어기는 거니까... -> 컴파일 에러 -> 실행 불가한 상태말함
 *
 *요청객체와 응답객체는 반드시 서버로부터 주입 받아야 하는 객체이다.
 *따라서 서블릿 안에 다른 메소드를 정의할 수는 있지만 아무 의미 없다 
 *왜냐면 요청객체와 응답객체가 없이는 아무것도 할 수가 없다 - web에서는 
 */
 
