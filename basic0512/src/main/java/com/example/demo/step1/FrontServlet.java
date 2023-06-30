package com.example.demo.step1;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//부모 클래스보다 자손클래스가 더 많은 메소드를 누릴 수 있다.
//메소드 오버라이드 전제 조건
//같은 메소드이름을 정의할 수 있다.
//단 메소드 오버라이딩 조건을 만족해야 한다
//서로 상속관계에 있다
//부모에 선언된 메소드 이름과 반드시 일치해야 한다
//자손클래스는 부모가 정의한 메소드를 누릴 수 있지만 부모클래스는 자손클래스가 정의한
//메소드를 재정의 또는 호출 불가하다 
//상속을 받을 때는 상위 클래스 보다는 하위 클래스를 상속 받는 것이 누릴게 더 많다
@SuppressWarnings("serial")
public class FrontServlet extends HttpServlet {

	@Override
	public void  doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
