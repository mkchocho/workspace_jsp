package com.example.demo.pojo2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	//서블릿(servlet-api.jar:톰캣서버)에게 예외처리를 미룬다 
	//예외처리를 직접 하지 않고 나를 호출한 곳에서 처리 받아라 - throws
	/*************************************************************************
	 * 
	 * @param req
	 * @param res
	 * @return "redirect:boardList.jsp", or "forward:boardList.jsp" or "redirect:boardList.pj2"
	 * @throws Exception
	 **************************************************************************/
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;

}
/*
	Action에서는 ActionForward이었다. 리턴 타입이
	(String path, boolean isRedirect(true:sendRedirec()로 처리, false이면 forward{select일때만}로 처리)
	path = "noticeList.pj1" -> substring 잘라냄 -> noticeList만 남김 -> 이 이름을 메소드 이름으로 사용함
	
	그런데 여기서는 String으로 변경하였다.
*/