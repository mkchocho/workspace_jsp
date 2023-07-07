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
 * 
 * 클래스 설계/아키텍처 구현
 * 하나 - getController 메소드를 선언했다 - 리턴타입과 파라미터를 결정하였다
 * 리턴타입은 Object이고요 -> 왜요? String 이거나 ModelAndView
 * 역할 : 어떤 업무인지에 따라서 연결되는 컨트롤러 클래스의 이름이 달라져야 하니깐..
 * MemberController, OrderController, PriceController 
 * 컨트롤러의 이름을 결정해 주는 단어는 member, order, price 
 * 어디서 가져오죠? - upmu[0]
 * 아 그래서 getController의 첫번째 파라미터 타입이 String배열이었군요...
 * 프레임워크란? 틀, 골격 제공함
 * 실력차이를 최소화 해주자
 * 일관된 구조를 사용해서 먼저 끝난 사람이 아직 진행중인 사람을 좀 돕자
 * 업무적인 depth
 * 추상클래스 중심의 인터페이스 중심 코딩을 전개하자 -> 클래스 간의 결합도를 낮추고 독립성을 높여서 단위(통합)테스트 가능
 * getController 안에서 일어나는 일들
 * -Controller3선언-인터페이스
 * -인스턴스화 -> 첫번째 if문이다 -> upmu[0] = member or order or price
 * 				:두번째 if문에서는 메소드 이름을 결정지어요 qnaList, qnaDetail, qnaInsert, qnaUpdate, qnaDelete
 * -메서드호출 -> 리턴타입(출력되는 페이지 이름), 파라미터 타입과 갯수
 *
 * 현재 설계에서 ModelAndView는 선택사항입니다.
 * ModelAndView타입을 리턴타입으로 결정하지 않더라도 WEB-INF/views/ 페이지를 호출할 수 있따
 * 
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
		//그래서 나는 아직 결정할 수 없었다
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
					logger.info("qnaList가 String타입이면 if문을 탐");
					//return "rediirect:qnaList.jap" → 배포위치 → webapp>qna
					//return "forward:qnaList.jsp" → 배포위치 → webapp>qna
					return(String)obj;
				}
			}//end of qnaList
			else if("jsonQnaList".equals(upmu[1])) {//배열의 두번째 방에 있는 문자열 - 페이지이름, 메소드이름, myBatis id
				logger.info("jsonQnaList - 회원조회");
				obj = controller.jsonQnaList(req, res);
				if(obj instanceof String) {//String타입으로 돌려줌 
					logger.info("jsonQnaList가 String타입이면 출력");
					//return "rediirect:qnaList.jap" → 배포위치 → webapp>qna
					//return "forward:qnaList.jsp" → 배포위치 → webapp>qna
					return(String)obj;
				}
			}//end of jsonqnaList
			else if ("qnaDetail".equals(upmu[1])) {//상세보기
				logger.info("qnaDetail - 상세보기");
				obj = controller.qnaList(req, res);
				if(obj instanceof String) {//String타입으로 돌려줌 
					return(String)obj;
				}
			}
			// end of qnaDetail
			else if ("qnaInsert".equals(upmu[1])) {//글등록
				logger.info("qnaInsert - 글등록");
				//첫번째 if문에서 upmu[0]있는 qna로 QnAController가 결정되었다(인스턴스화-메모리상주)
				//둘 메소드의 파라미터로 req, res 원본을 넘겨서 QnAController 서블릿을 상속받지 않아도 됨
				//상속을 받게 되면 자유도 떨어짐 
				obj = controller.qnaInsert(req, res);
				//왜 String만 비교하나요? ModelAndView는 없나요? 왜요?
				if(obj instanceof String) {//String 타입으로 돌려줌
					//누가 언제 리턴해 주는 정보인가요?
					return(String)obj;
				}
				//글등록이 성공한 다음에 목록페이지로 이동합니다.
				//오라클 서버를 경유해서 새로 등록된 글 내용도 새로 가져와야 함
				//forward-forward 이렇게 연결은 불가함
				//목록조회를 qnaList로 설계하였으므로 그 이름이 호출되도록 요청하면 됨 
				//오라클 서버를 직접 요청하는 것이 아니라 오라클 서버를 경유 하는 메소드를 호출하면 됨 
				//redirect로 처리하면 충분하다 - 메소드 호출만 해주면 나머지는 알아서 해주니까
				
			}// end of qnaInsert
			//http://localhost:9000/qna/qnaUpdate.pj3
			else if ("qnaUpdate".equals(upmu[1])) {//글수정
				logger.info("qnaUpdate - 글수정");
			}// end of qnaUpdate
			//http://localhost:9000/qna/qnaDelete.pj3
			else if ("qnaDelete".equals(upmu[1])) {//글삭제
				logger.info("qnaDelete - 글삭제");
				obj = controller.qnaDelete(req, res);
				if(obj instanceof String) {
					return(String)obj;
				}
			}// end of qnaDelete
		}/////////////////////end of QnA게시판//////////////////////////////
		return obj;
	}
}
