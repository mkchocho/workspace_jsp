package com.example.demo.pojo3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller3 {//log4j가 동일한 이름으로 제대로 인식하지 못해서 3붙임
	//카카오 로그인 콜백(사용자가 요청시 카카오 서버측에서 호출하는 메소드) 메소드 선언
	public Object kakaoCallback(HttpServletRequest req, HttpServletResponse res);//return 타입 class해보기->String->Object
	
}
