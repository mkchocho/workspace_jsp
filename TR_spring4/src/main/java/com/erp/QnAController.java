package com.erp;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
//Pars로 시작하는 Exception발생함 - xml문서 오타 - 대소문자, 공백문자, 하이픈
//SAX로 시작하는 Exception발생함 - xml문서 오타
//상속을 통해서 컨트롤 계층 설계하고 운영함 
							//아래를 상속받으면 req, res를 주입해줌 
public class QnAController extends MultiActionController{
	Logger logger = Logger.getLogger(QnAController.class);//설계도를 얻어내서 로그 관리를 해줌
	//메소드 파라미터 자리에 사용하지 않더라도 req와 res가 반드시 선언되어 있어야 호출이 된다
	//아직 서블릿에 의존적인 프레임워크 이기 때문에 그렇다.
	public ModelAndView qnaList(HttpServletRequest req, HttpServletResponse res) {
		logger.info("qnaList");
		List<Map<String,Object>> qList = null;
		ModelAndView mav = new ModelAndView();
		mav.addObject("qList",qList);//화면유지 - reqeust scope 가짐
		//pageMove[0]=qna, pageMove[1] =qnaList
		mav.setViewName("qna/qnaList"); 
		return mav;
	}

}