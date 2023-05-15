package com.example.demo.step1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
@WebServlet("/rest/test")
public class RestfulServlet extends HttpServlet {
	Logger logger = Logger.getLogger(RestfulServlet.class);

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("doDelete"); //405번이면 대응하는 메소드 이름 오타
	
}

	//GET전송방식이 디폴트이다
	//GET방식은 쿼리스트링으로 값을 받을 수 있다
	//GET방식은 링크를 걸 수 있다
	//단 전송데이터의 크기는 브라우저마다 제약이 따른다
	//사용자가 입력한 값이 그대로 노출됨 - 보안 취약 - 로그인 구현시에는 사용하지 말자
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("doGet"); //405번이면 대응하는 메소드 이름 오타
		//사용자가 화면에 입력한 값을 단위테스트 가능하다. - POST방식은 불가함 - 그래도 하고 싶으면 Postman도구
		// <input type =text id="" name"mem_id">
		//파라미터 자리에는 입력받는 콤포넌트의 name이 와야 한다. 
		String mem_id = req.getParameter("mem_id");
		String mem_name = req.getParameter("mem_name");
		//화면 없이도 사용자가 입력한 값을 postman을 통해서 단위테스트 가능함
		//마임타입은 응답페이지와 관계있으니 응답객체를 사용한다
		resp.setContentType("text/html;charset=utf-8"); //응답객체
		PrintWriter out = resp.getWriter();//메소드 호출의 리턴 값으로 객체를 주입받음
		out.print("<div>"+mem_id+"<div>"); 
		//resp.sendRedirect("페이지 이름 써준다");

	       
	       
		}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("doPost"); //405번이면 대응하는 메소드 이름 오타
		String mem_id = req.getParameter("mem_id");
		String mem_pw = req.getParameter("mem_pw");
		}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("doPut"); //405번이면 대응하는 메소드 이름 오타
	}

}