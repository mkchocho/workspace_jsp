package com.example.demo.pojo3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
/*
 * 클래스 설계시에 메서드에서 하는 역할은 생성자 안에서도 가능함(제어문 사용, 메서드 호출, 변수 선언)
 * 같은 이름의 생성자를 여러 개 선언할 수 있다 - 메서드 오버로딩이랑 같은 규칙
 * POJO1-1
 * POJO1-2
 * upmu[] - 0번에는 업무이름(폴더명), 1번에는 메서드 이름==myBatis 쿼리 id값
 * pageMove[] - pageMove[0] = redirect or forward, pageMove[1] = boardList
 * 위 배열 모두를 누가 생성? - FrontMVC, ActionServlet, ActionSupport
 * upmu배열은 requestURI -> URL주소로 결정되는 값
 * 응답페이지 처리에 대한 책임도 이 클래스가 가져야 함 - DispatcherServlet
 * 생성은 FrontMVC, ActionServlet, ActionSupport가 그런데 사용은 ViewResolver가 사용할거니까
 * 생성자의 파라미터로 원본을 가져온다 - 인스턴스화(게으른 인스턴스화 or 이른 인스턴스화), 의존성 주입
 * 이 클래스의 역할은 화면처리 
 * 선택지가 2가지 이다
 * 1) webapp아래 배치된 경우
 * : 다시 2가지로 나눔 -> redirect, forward
 * 2) WEB-INF/views/아래 배치된 경우
 */

public class ViewResolver {
	Logger logger = Logger.getLogger(ViewResolver.class);
	
	public ViewResolver() {	} // 디폴트 생성자 - req가 없다, res도 없다 - res.sendRedirect할 때 필요함
	
	public ViewResolver(String pageMove[]) { }
	// 나를 호출하는 쪽에서 메서드의 파라미터를 통해서 주입을 받아온다(원본 주소번지를 받아온다 -> 얕은 복사)
	public ViewResolver(HttpServletRequest req, HttpServletResponse resp, String pageMove[]) throws ServletException, IOException { 
	String path = pageMove[1];
	// redirect해야 되나?
	// url이 바뀐다 -> 기존 요청이 끊어졌다가 새로운 요청으로 페이지가 열렸다
	// 유지가 되지 않고 있다 -> req.getAttribute 해봤자 꺼내올 수 있는 값이 전혀 없다
	if ("redirect".equals(pageMove[0])) { // return "redirect:dept/getDepList"
		logger.info(path);
		resp.sendRedirect(path);
		return;
	}
	// 아래 if문의 공통점은 scope가 request인 것이다.
	// 아래 if문의 차이점은 첫번째 것은 req에 직접 담는다는 점이고
	// 아래 else문은 ModelAndView에 담는 점이다.
	// else인 경우를 설계한 이유는 jsp문서를 WEB-INF 폴더에 감추기 위해서이다
	// forward로 해야 되나?
	else if ("forward".equals(pageMove[0])) { // return "forward:dept/getDepList"
		//변수 path에는 두번째 방에 있는 값이 들어갑니다. 
		RequestDispatcher view = req.getRequestDispatcher("/" + path + ".jsp");
		view.forward(req, resp);
	}
	// 보안 때문에 WEB-INF로 해야 되나?
	else { // redirect도 아니고 forward도 아닌 경우인가?
		path=pageMove[0]+"/"+pageMove[1];
		RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/views/" + path + ".jsp");
		view.forward(req, resp);
	}
	
  }  	
	
}