package com.example.demo.pojo3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.util.HashMapBinder;
// Controller3의 구현체 클래스가 된다는 건 추상메소드를 오버라이딩 해야함
// 내가 다 필요하지 않아도 반드시 오버라이딩 해야 함 - 제약조건 - 명세서이다.
public class QnAController implements Controller3{
	Logger logger = Logger.getLogger(QnAController.class);
	private QnALogic qnaLogic=new QnALogic();
/********************************************************************************
 * 조회결과 JSON형식으로 꺼내오기 - 페이지가 아니라...{리액트 비벼보기}
 * 리턴타입은 String으로 한다
 * JSON을 지원하는 Gson API활용하기
 *********************************************************************************/
	@Override
	public Object jsonQnaList(HttpServletRequest req, HttpServletResponse res) {
		logger.info("jsonQnaList");
		List<Map<String,Object>> qList = null;
		Map<String,Object> pMap = new HashMap<String, Object>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pMap);
		qList = qnaLogic.qnaList(pMap);
		Gson g = new Gson();
		String temp = g.toJson(qList);
		return temp;
	}
	/********************************************************************************
	 * 조회결과 JSP 페이지에 출력하기
	 * 리턴타입은 String으로 한다 (그러면 webapp 아래에 페이지를 배포할 것.)
	 * 예시) "forward:/qna/qnaList" -> pageMove[0]=forward, pageMove[1]=qna/qnaList
	 * {spring에서는 자동으로 지원해줌 - ViewResolver 설정이 추가됨}
	 * SELECT qna_no, qna_writer, qna_title, qna_content FROM qna
	 * SELECT * FROM qna_comment - 답글에 대한 테이블을 별도로 설계해보기 
	 *********************************************************************************/
	@Override
	public Object qnaList(HttpServletRequest req, HttpServletResponse res) {
		logger.info("qnaList");
		List<Map<String,Object>> qList = null;
		Map<String,Object> pMap = new HashMap<String, Object>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pMap);
		qList = qnaLogic.qnaList(pMap);
		req.setAttribute("qList", qList);
		//"/WEB-INF/views/"+"이자리"+".jsp"
		return "qna/qnaList";
	}
	/********************************************************************************
	 * JSP 상세보기 페이지에 출력하기
	 * 리턴타입은 String으로 한다 (그러면 webapp 아래에 페이지를 배포할 것.)
	 * 예시) "forward:/qna/qnaDetail" -> pageMove[0]=forward, pageMove[1]=qna/qnaDetail
	 * {spring에서는 자동으로 지원해줌 - ViewResolver 설정이 추가됨}
	 * SELECT qna_no, qna_writer, qna_title, qna_content FROM qna
	 * SELECT * FROM qna_comment - 답글에 대한 테이블을 별도로 설계해보기 
	 *********************************************************************************/
	@Override
	public Object qnaDetail(HttpServletRequest req, HttpServletResponse res) {
		logger.info("qnaDetail");
		List<Map<String,Object>> qList = null;
		Map<String,Object> pMap = new HashMap<String, Object>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pMap);
		qList = qnaLogic.qnaList(pMap);
		req.setAttribute("qList", qList);
		return "forward:qna/qnaDetail";
	}
	/********************************************************************************
	 * 질문등록하기
	 * 리턴타입은 Integer으로 한다 (그러면 webapp 아래에 페이지를 배포할 것.)
	 * 등록이 성공하면 어디로 갈 것인가?
	 * 등록 성공시에 목록으로 이동처리 할 것이라면 "redirect:qna/qnaList.pj3"
	 * 주의 : 확장자가 jsp로 끝나면 오라클 서버를 경유하지 않았다.
	 * 오라클 서버를 경유하려면 XXX.pj3으로 끝나야 한다. 반드시
	 * INSERT INTO qna VALUES(?,?,?,......)
	 *********************************************************************************/
	@Override
	public Object qnaInsert(HttpServletRequest req, HttpServletResponse res) {
		logger.info("qnaInsert");
		int result =-1; //입력 성공이면 1을 돌려받고 실패이면 0을 받음(오라클 서버가 응답으로 준다)
		Map<String,Object> pmap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		//HashMapBinder 클래스가 사용자가 화면에 입력한 값들을 자동으로 파라미터 주소번지에 담아줌 
		hmb.bind(pmap);
		result = qnaLogic.qnaInsert(pmap);//파라미터 pmap의 주소번지를 오라클 서버에까지 전달해줌
		return "redirect:qnaList.pj3";
	}

	@Override
	public Object qnaUpdate(HttpServletRequest req, HttpServletResponse res) {
		logger.info("qnaUpdate");
		int result =-1; //입력 성공이면 1을 돌려받고 실패이면 0을 받음(오라클 서버가 응답으로 준다)
		Map<String,Object> pmap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		//HashMapBinder 클래스가 사용자가 화면에 입력한 값들을 자동으로 파라미터 주소번지에 담아줌 
		hmb.bind(pmap);
		result = qnaLogic.qnaUpdate(pmap);//파라미터 pmap의 주소번지를 오라클 서버에까지 전달해줌
		return "redirect:qnaList.pj3";
	}

	@Override
	public Object qnaDelete(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res, Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		return null;
	}
	//아래는 카카오 로그인때 만 필요한 메소드인데 여기서는 죽어도 필요없다
	@Override
	public Object kakaoCallback(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object boardList(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object jsonBoardList(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

}
