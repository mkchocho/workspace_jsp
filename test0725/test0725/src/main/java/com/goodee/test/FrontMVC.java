package com.goodee.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public class FrontMVC extends HttpServlet {
	Logger logger = Logger.getLogger(FrontMVC.class);
	protected void doService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("doService");
		ActionForward af = null;
		String uri = req.getRequestURI(); //=>/notice/noticeList.pj1
		logger.info(uri);
		String context = req.getContextPath();//=>/
		String command = uri.substring(context.length()+1);
		int end = command.lastIndexOf(".");//.pj1이 있는 위치 정보
		command = command.substring(0,end);//.pj1이 잘려나간 문자열만 남음 -> /notice/noticeList
		String upmu[] = null; //upmu[0]=notice, upmu[1]=noticeList
		upmu=command.split("/");
		for(String str:upmu) {//개선된 for문. 전체 출력할 땐
		}
		NoticeController noticeController = new NoticeController();
		if("notice".equals(upmu[0])) {
			req.setAttribute("upmu", upmu);//배열의 주소번지 
			af = noticeController.execute(req, resp);
		}
		if(af !=null){
			if(af.isRedirect()) {
				resp.sendRedirect(af.getPath());
				return;
			}//end of redirect - insert, update, delete
			else {
				RequestDispatcher view = req.getRequestDispatcher(af.getPath());//상수가 아니라 변수 변수아니라 메소드 처리하는 코드
				view.forward(req,resp);
			}//end of forward 
		}//end of if - ActionForward결과로 후처리하는 코드 끝나는 부분이었습니다
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doService(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doService(req, resp);
	}

}
