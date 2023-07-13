package com.di;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
//추상클래스보다 인터페이스가 더 추상적이다.
//인터페이스를 구현하는 구현체 클래스가 되었다
//추상메소드를 재정의해서 기능을 결정짓는다
//장점 : 클래스의 재사용성을 높이면서도 결합도는 낮춰준다 
public class MapController implements Controller{
	Logger logger = Logger.getLogger(MapController.class);
	Map<String,Object> insaMapBean = null;
	
	public void setInsaMapBean(Map<String, Object> insaMapBean) {
		this.insaMapBean = insaMapBean;
	}
	
	//추상메소드는 제약조건이라서 메소드의 파라미터 리턴타입 어느 하나도 임의로 바꿀 수 없다.
	//그래서 POJO처럼 해 본다
	//리턴 타입은 null로 처리했다
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info(insaMapBean);
		ModelAndView mav = new ModelAndView(); // 관리를 받는다. - spring container
		mav.addObject("insaMapBean", insaMapBean);
		req.setAttribute("insaMapBean", insaMapBean);
		//아래 처럼 페이지를 요청하면 배포 위치가 달라져야 한다.
		//ModelAndView - /WEB-INF/views/
		//null - /webapp/di/
		RequestDispatcher view = req.getRequestDispatcher("./insaMapList.jsp");
		view.forward(req,res);
		return null;
	}
	
	



}
