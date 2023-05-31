package com.example.demo.pojo1;


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
	//사용자 정의 메소드
	//아래 메소드를 호출하는 URL패턴은 무엇입니까?
	//http://localhost:9000/notice/noticeList.pj1
	//http://localhost:9000/xxx.pj1
	protected void doService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("doService");
		ActionForward af = null;
		String uri = req.getRequestURI(); //=>/notice/noticeList.pj1
		logger.info(uri);
		//context 정보는 server.xml에서 확인 가능함
		String context = req.getContextPath();//=>/
		String command = uri.substring(context.length()+1);
		int end = command.lastIndexOf(".");//.pj1이 있는 위치 정보를 가져옴
		command = command.substring(0,end);//.pj1이 잘려나간 문자열만 남음 -> /notice/noticeList
		String upmu[] = null; //upmu[0]=notice,upmu[1]=noticeList -> 페이지이름과 메소드이름 통일함 
		//슬래시를 기준으로 문자열을 썰어서 배열에 순서대로 담아
		upmu=command.split("/");
		//테스트하기 - http://localhost:9000/notice/noticeList.pj1엔터
		for(String str:upmu) {//개선된 for문. 전체 출력할 땐
			//logger.info(str); 2번 출력됨 
		}
		//여기까지 pj1으로 요청이 들어 왔을 때 web.xml을 통해서 FrontMVC클래스의 doService메소드 호출됨을
		//확인하였다. 그 다음은 NoticeController의 execute메소드 호출하기이다.
		NoticeController noticeController = new NoticeController();
		if("notice".equals(upmu[0])) {
			//바로 아래 코드때문에 NoticeController는 서블릿이 아니어도 괜찮고 
			//그럼에도 request와 response객체를 누릴 수 있다.-NullPointerException발생하지 않음 - 잘된 설계
			//선언이 사용보다 먼저 이다.
			req.setAttribute("upmu", upmu);//배열의 주소번지 
			af = noticeController.execute(req, resp);
		}
		if(af !=null){
			if(af.isRedirect()) {
				resp.sendRedirect(af.getPath());
				//응답이 이미 커밋된 후에는 forward할 수 없습니다.
				//redirect이 후에 return을 줘야만 JSP절차가 정상적으로 종료 됨
				return;
			}else {
				RequestDispatcher view = req.getRequestDispatcher(af.getPath());//상수가 아니라 변수 변수아니라 메소드 처리하는 코드
				view.forward(req,resp);
			}
		}//end of if - ActionForward결과로 후처리하는 코드 끝나는 부분이었습니다
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
 
