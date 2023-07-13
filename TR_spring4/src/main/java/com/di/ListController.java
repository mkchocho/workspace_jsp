package com.di;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
//나도 DispatcherServlet의 관리를 받고 싶어 -> extends AbstractController 
//request, response 누릴 수 있다
//메소드의 파라미터로 받아낸다 
//syntax 정해짐 
//추상메소드 - 제약조건 - 반드시 구현해줘 - 재정의
public class ListController extends AbstractController{
	Logger logger = Logger.getLogger(ListController.class);
	//setter 이름은 반드시 property name과 일치해야함
	//F/W에는 다양한 컨벤션이 있어서 자바코드와 xml코드를 항상 맞춰야 함 - 헬 -> 어노테이션
	//<property name = "insaBean"
	List<?> insaBean = null;
	public void setInsaBean(List<?> insaBean) {
		this.insaBean = insaBean;
	}
	

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info(insaBean);//List<?>
		ModelAndView mav = new ModelAndView();
		mav.addObject("insaBean",insaBean);
		//spring-servlet.xml을 보면 ViewResolver 객체가 접두어와 접미어를 제공하고 있음
		// -> /WEB-INF/views/di/insaList.jsp
		mav.setViewName("di/insaList");
		return mav;

	}

}
