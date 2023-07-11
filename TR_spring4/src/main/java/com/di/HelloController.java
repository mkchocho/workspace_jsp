package com.di;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloController extends AbstractController{
	Logger logger = Logger.getLogger(AbstractController.class);

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		logger.info("handleRequestInternal");
		List<String> insa = new ArrayList<>();
		insa.add("안녕하세요");
		insa.add("hello");
		ModelAndView mav = new ModelAndView();
		mav.addObject("insa",insa);
		mav.setViewName("di/hello"); //->WEB-INF/views/di/hello.jsp
		return mav;
	}

}
