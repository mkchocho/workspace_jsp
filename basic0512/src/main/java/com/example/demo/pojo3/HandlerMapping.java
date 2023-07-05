package com.example.demo.pojo3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/*
 * if문을 대신 할거야 - 왜냐면 직관적이지가 않으니까...
 * Controller controller = new MemberController();
 * controller = new OrderController();
 * controller = new PriceController();
 * 처리를 한다는 건 메소드를 정의하라
 */
public class HandlerMapping {
	static Logger logger = Logger.getLogger(HandlerMapping.class);
	//메소드 파라미터 자리는 지변이다
	//메소드의 파라미터를 통해서 주소번지 즉 원본을 사용할 수 있다. - 생성자에서도 동일함 
	public static Object getController(String[] upmu, HttpServletRequest req, HttpServletResponse res) {
		logger.info(upmu[0]+","+upmu[1]); // qna, qnaList / qna, qnaInsert / qna, qnaUpdate / qna, qnaDelete 
		Object obj = null;
		//인터페이스가 먼저오고 생성부에 구현체 클래스가 온다 → 폴리모피즘, 다형성 (객체지향 프로그래밍 전개하기)
		//다형성? 같은 메서드를 호출하더라도 그 기능이 생성부에 오는 클래스에 따라서 바뀐다  
		Controller3 controller = null;//인터페이스
		if("board3".equals(upmu[0])) {
			logger.info("게시판 1-3");
			//insert here{위치잡기} - 인스턴스화
			controller = new Board3Controller();//24번 인터페이스 → 드디어 구현체 클래스가 결정됨
			//위에서 이번 요청에 대한 컨트롤러 클래스가 결정되었으니
			//그 다음에는 메소드 이름을 결정해야 한다.
			if("boardList".equals(upmu[1])) {
				//1~3번에서는 사용자가 정의하는 메소드도 req와 res를 사용할 수 있게 됨
				obj = controller.boardList(req,res);
				//위 메소드의 리턴타입으로 List<Map>을 받게 됨 - 왜냐하면 select이니깐 - 전체조회
				if(obj instanceof ModelAndView) {
					return (ModelAndView)obj;
				}//boardList메소드 실행 후에 리턴타입을 비교함 
				else if(obj instanceof String) {
					return (String)obj;
				}//boardList메소드의 리턴타입이 String이니? - select임 - forward:board/boardList
				//pageMove[0] = forward
				//pageMove[1] = board/boardList
				//-> http://localhost:9000/board/boardList.jsp -> ViewResolver가 해줌 
			}////////////////end of boardList()///////////////////////////
			
			else if ("jsonBoardList".equals(upmu[1])) {
				//insert here
				obj = controller.jsonBoardList(req,res);
				logger.info(obj);
				//위 메소드의 리턴타입으로 List<Map>을 받게 됨 - 왜냐하면 select이니깐 - 전체조회
				if(obj instanceof ModelAndView) {
					logger.info("ModelAndView");
					return (ModelAndView)obj;
				}//boardList메소드 실행 후에 리턴타입을 비교함 
				else if(obj instanceof String) {
					logger.info("String");
					return (String)obj;
				}
			}//end of jsonBoardList - 리액트와 비벼보기
			
		}////////////////////end of 자유게시판/////////////////////////////
		else if("qna".equals(upmu[0])) {
			logger.info("upmu[0]=qna");
			//insert here{위치잡기} - 인스턴스화
			controller = new QnAController(); // 구현체 클래스가 결정됨 
			//Qna 글목록 메소드 호출
			//POJO1-3에서는 upmu[1]방에 있는 정보가 @GetMapping("qnaList");
			if("qnaList".equals(upmu[1])) {//배열의 두번째 방에 있는 문자열 - 페이지이름, 메소드이름, myBatis id
				logger.info("qnaList - 회원조회");
				obj = controller.qnaList(req, res);
				if(obj instanceof ModelAndView) {//컨트롤러 클래스가 ActionSupport에게 돌려주는 객체이다 
					return (ModelAndView)obj;//배포위치 → /WEB-INF/views/qna
				}else if(obj instanceof String) {//String타입으로 돌려줌 
					//return "rediirect:qnaList.jap" → 배포위치 → webapp>qna
					//return "forward:qnaList.jsp" → 배포위치 → webapp>qna
					return(String)obj;
				}
			}//end of qnaList
			else if ("qnaDetail".equals(upmu[1])) {//상세보기
				logger.info("qnaDetail - 상세보기");
				}
			// end of qnaDetail
			else if ("qnaInsert".equals(upmu[1])) {//글등록
				logger.info("qnaInsert - 글등록");
				obj = controller.qnaInsert(req, res);
				if(obj instanceof ModelAndView) {//컨트롤러 클래스가 ActionSupport에게 돌려주는 객체이다 
					return (ModelAndView)obj;//배포위치 → /WEB-INF/views/qna
				}else if(obj instanceof String) {//String타입으로 돌려줌 
					//return "rediirect:qnaList.jap" → 배포위치 → webapp>qna
					//return "forward:qnaList.jsp" → 배포위치 → webapp>qna
					return(String)obj;
				}}// end of qnaInsert
			//http://localhost:9000/qna/qnaUpdate.pj3
			else if ("qnaUpdate".equals(upmu[1])) {//글수정
				logger.info("qnaUpdate - 글수정");
			}// end of qnaUpdate
			//http://localhost:9000/qna/qnaDelete.pj3
			else if ("qnaDelete".equals(upmu[1])) {//글삭제
				logger.info("qnaDelete - 글삭제");
			}// end of qnaDelete
		}/////////////////////end of QnA게시판//////////////////////////////
		return obj;
	}
}
