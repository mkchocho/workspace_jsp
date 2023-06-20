package com.example.demo.pojo3;

import org.apache.log4j.Logger;
/*
 * spring4.0 버넞까지 응답페이지 처리시에 활용 됨
 * spring boot에 와서는 Model이나 ModelMap으로(메소드의 파라미터로 제공) 대체 되었다
 * Model, ModelMap은 스프링에서 ui지원하는 객체임 
 * ModelAndView의 scope(page|request|session|application)가 request이었다.
 * 응답페이지 위치는 WEB-INF/views/XXX.jsp
 *접두어 /WEB-INF/views/
 *접미어 .jsp 붙여서 응답 URL패턴을 완성함
 *예) /WEB-INF/views/화면이름.jsp
 */

public class ModelAndView {
	Logger logger = Logger.getLogger(ModelAndView.class);
}
