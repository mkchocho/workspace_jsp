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
	 * http//localhost:9000/WEB-INF/views/qna/qnaList.jsp로 요청하면 404번 발생함
	 * WEB-INF아래는 절대로 접근이 불가함 - 보안상 필요한 경우에 배포하는 위치임
	 * 그러나 톰캣과 같은 WAS컨테이너는 내부적으로 접근 가능함 
	 * 리턴타입은 String으로 한다 (그러면 webapp 아래에 페이지를 배포할 것.)
	 * 예시) "forward:/qna/qnaList" -> pageMove[0]=forward, pageMove[1]=qna/qnaList
	 * {spring에서는 자동으로 지원해줌 - ViewResolver 설정이 추가됨}
	 * SELECT qna_no, qna_writer, qna_title, qna_content FROM qna
	 * SELECT * FROM qna_comment - 답글에 대한 테이블을 별도로 설계해보기 
	 * qnaList앞에 jsonQnaList이면 html이 아닌 문자열로 출력이 나가야 하고(JSON)
	 * json접두어가 없으면 출력이 html 태그로 나가야 한다.
	 *********************************************************************************/
	@Override
	public Object qnaList(HttpServletRequest req, HttpServletResponse res) {
		logger.info("qnaList");
		List<Map<String,Object>> qList = null;
		//HashMapBinder는 서블릿이 아니므로 생성자의 파라미터로 넘겨줌 
		Map<String,Object> pMap = new HashMap<String, Object>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pMap);
		qList = qnaLogic.qnaList(pMap);
		logger.info(qList);//자바의 자료구조 문자열값 출력됨
		req.setAttribute("qList", qList);//요청객체에 조회 결과를 담음
		//"/WEB-INF/views/"+"이자리"+".jsp"
		//아래의 리턴값은 HandlerMapping클래스로 전달됨
		//pageMove[]에 담기게 되는데 아래와 같이 리턴값을 내보내면
		//http://localhost:9000/qna/qna/qnaList.pj3 -> qna가 연속해서 출력됨
		//pageMove[0]=qna, pageMove[1]=qna, pageMOve[2]=qnaList저장됨
		//그런데 현재 배열값은 두개만 사용하는 구조로 설계가 됨
		//앞에 redirect나 forward가 없으면 WEB-INF/views/+path+.jsp로 URL이 완성됨 
		return "qna/qnaList";
		//위는 누구에게 돌려주는 값? -> ActionSupport가 받아서 VeiwResolver로 보냄 
		//어디를 보면 이 답을 찾을 수 있을까?
		//누가 언제 나를 호출했니? - HandlerMapping or ActionSupport 
		//어디서 부터 시작되었나? -> qna/qnaList.pj3 -> ActionSupport 경유
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
		//qna를 빼도 되는 이유는 현재 내가 바라보는 경로가 qna이다
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
		//qna를 빼도 되는 이유는 현재 내가 바라보는 경로가 qna이다
		return "redirect:qnaList.pj3";
	}

	@Override
	public Object qnaDelete(HttpServletRequest req, HttpServletResponse res) {
		int result =-1; //입력 성공이면 1을 돌려받고 실패이면 0을 받음(오라클 서버가 응답으로 준다)
		Map<String,Object> pmap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		//HashMapBinder 클래스가 사용자가 화면에 입력한 값들을 자동으로 파라미터 주소번지에 담아줌 
		hmb.bind(pmap);
		result = qnaLogic.qnaDelete(pmap);//파라미터 pmap의 주소번지를 오라클 서버에까지 전달해줌
		return "redirect:qnaList.pj3";
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
