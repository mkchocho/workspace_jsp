package com.example.demo.pojo3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public class ActionSupport extends HttpServlet {
	Logger logger = Logger.getLogger(ActionSupport.class);

	protected void doService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("doService");
		String uri = req.getRequestURI();// => /board3/boardList.pj3
		String context = req.getContextPath();//=> / <Context docBase="basic0512" path="/" 
		String command = uri.substring(context.length()+1);
		int end = command.lastIndexOf("."); // .pj3이 있는 위치 정보를 가져옴
		command = command.substring(0, end); // command = "member2/memberList" 
		String upmu[] = null;	
		upmu = command.split("/");
		Object obj = null; //HandlerMapping에 return타입이 Object인 메소드 getController

		//insert here - HandlerMapping과 비벼보기 //HandpleMapping - 페이지처리
		obj = HandlerMapping.getController(upmu,req,resp);//객체생성하지 않고 싱글톤으로 사용할려고 HandlerMapping의 메소드를 static으로 변경함
		//여기 핸들러 매핑이 가지고 있는 코드 때문에 필요 없어졌어 핸들러 매핑은 obj를 리턴함 		
		//		if("member2".equals(upmu[0])) {
		//			logger.info("member2");
		//			controller = new Member2Controller();
		//			req.setAttribute("upmu", upmu); //저장하기
		//			page = controller.execute(req,resp);
		//		}
		//		if("board".equals(upmu[0])) {
		//			controller = new BoardController();
		//			req.setAttribute("upmu", upmu); //배열의 주소번지
		//			page = controller.execute(req, resp);
		//		}//내려 갈 때 전처리 코드
		if(obj!=null) {
			String pageMove[] = null;
			ModelAndView mav = null;
			//Object 안에는 두가지 타입이 있다 - String, ModelAndView
			if(obj instanceof String) {
				if(((String)obj).contains(":")) {
					logger.info("내 안에 콜론있어요");
					pageMove = obj.toString().split(":");
				}
				else if(((String)obj).contains("/")) {
					logger.info("내 안에 슬래쉬있어요");
					pageMove = obj.toString().split("/");
				}
				else {
					logger.info("내 안에 콜론도 없고 슬래쉬도 없어요");
				}//end of if -> 응답문자열을 배열에 담기
			}//end of String - 컨트롤클래스의 리턴타입이 String일 때 처리기
			//너 리턴타입이 ModelAndView야? - HandlerMapping, 내 안에서 인스턴스화가 됨, 메소드 이름이 직관적임 - POJO1-2와 차이점 : 인스턴스화 하고 execute()메소드를 사용했었음 
			//ModelAndView는 스프링에서 UI{select:조회결과}를 지원하기 위해 설계되었다
			else if(obj instanceof ModelAndView) {
				mav = (ModelAndView)obj;
				pageMove = new String[2];
				pageMove[0]="forward"; // 상수처리 : spring의 방식 모방 중
				pageMove[1]="페이지이름";//boardList or memberList or noticeList(확장자빼고)
			}
			////////////////////////////////////////////////////////////////////////////////////////
			/////////////////////////////////////[[ViewResolver]]//////////////////////////////////스프링할땐 필요없는 부분
			//insert here
			//pageMove 원소의 갯수가 2개일 때 - 백엔드 처리된 결과를 화면으로 처리할 때
			if(pageMove!=null && pageMove.length==2) {
				logger.info("pageMove 원소의 갯수가 2개 일때");
				String path = pageMove[1];
				//redirect로 할까?
				if("redirect".equals(pageMove[0])) {//return "redirect:dept/getDeptList"
					resp.sendRedirect(path);
				}
				//forward로 해야돼?
				else if("forward".equals(pageMove[0])) {//return "forward:dept/getDeptList"
					RequestDispatcher view = req.getRequestDispatcher("/"+path+".jsp");
					view.forward(req,resp);
				}
				//보안때문에 WEB-INF로 보내줄까
				else {//redirect도 없고 forward도 없는 경우야?
					RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/views/"+path+".jsp");
					view.forward(req,resp);
				}
			}/////////////////////end of pageMove원소의 개수가 2개일 때///////////////////////
			//pageMove의 원소의 갯수가 1개일 때 - 화면이 아닌 경우를 처리하기 위해서 설계함 - 단순문자열이거나 JSON포맷(React 배려하는 설계임) 
			else if(pageMove!=null && pageMove.length==1) {
				logger.info("pageMove 원소의 갯수가 1개 일때");

			}////////////////////////end of pageMove 갯수가 1개일 때 - 화면이 아닌 문자열이나 JSON 포맷지원할 때 (spring - @RestController대신 해줌)
			//원시적인 방법 또는 레거시 시스템을 공부하는 건 자동으로 처리하다가 문제가 발생하거나 해당 프레임워크가 지원을 안해주더라도
			//표준적인 방법을 알고 있으면 해결할 수 있다.(실마리, 컨벤션, 힌트, 아이디어 제공...)
			
			/////////////////////////////////////[[ViewResolver]]/////////////////////////////////

		}//page가 null이 아니면 후처리 
	} // end of doService

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doService(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doService(req, resp);
	}
}
