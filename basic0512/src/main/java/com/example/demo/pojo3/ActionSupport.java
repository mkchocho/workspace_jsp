package com.example.demo.pojo3;
/*
 * ActionSupport에는 두 개의 배열이 있다.
 * 1) upmu[]  
 * 2) pageMove[]
 * 둘 중에서 메소드 이름을 결정 짓는 역할은 XXX이다. -> upmu배열
 * 위 문제에 대한 답을 좀 더 구체적으로 말해 본다면? upmu[1]값이 메소드이름==if문조건값==mybatis id값이다.
 * redirect 혹은 forward 키워드를 가지는 배열은 누구 일까요? pageMove배열 -> 첫번째방 - 인덱스 0
 * @RestController 존재이유 -> React 존재함 //List나 Map이 아니라 Json으로 내보낼 수 있음
 * 컨셉이 뭔가요? 
 * 화면으로 내려지는게 꼭 html이 아니어도 괜찮아 - 화면이 그려지지 않아도 돼
 * 화면은 React로 그릴게
 * 화면은 VueJS로 그린다
 * 화면은 jEasyUI로 그린다.
 * 위와 같은 상황에서 백엔드를 구현하고 있다면 백엔드에서 내보내지는 정보가 List나 Map이거나 자바이어서는 안된다
 * spring과 리액트 비벼보기
 * 
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public class ActionSupport extends HttpServlet {
	Logger logger = Logger.getLogger(ActionSupport.class);

	protected void doService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("doService");
		String uri = req.getRequestURI();// => /board3/boardList.pj3
		String context = req.getContextPath();//=> / <Context docBase="basic0512" path="/" 
		logger.info(uri);
		String command = uri.substring(context.length()+1);
		int end = command.lastIndexOf("."); // .pj3이 있는 위치 정보를 가져옴
		command = command.substring(0, end); // .pj3이 잘려나간 문자열만 남음 → command = "member2/memberList" 
		logger.info(command);
		String upmu[] = null; //upmu[0] = qna, upmu[1] = qnaList
		//왜 pj3은 upmu[1]에 들어가지 않나요?
		upmu = command.split("/");//배열 초기화 upmu[0]=qna, upmu[1]=xxx 
		Object obj = null; //HandlerMapping에 return타입이 Object인 메소드 getController

		//insert here - HandlerMapping과 비벼보기 //HandpleMapping - 페이지처리
		obj = HandlerMapping.getController(upmu,req,resp);//객체생성하지 않고 싱글톤으로 사용할려고 HandlerMapping의 메소드를 static으로 변경함
		//위 obj 변수에 담기는 정보는 HandlerMapping에서 날아왔다 
		//여기 핸들러 매핑이 가지고 있는 코드 때문에 필요 없어졌어 핸들러 매핑은 obj를 리턴함 		
		//		if("member2".equals(upmu[0])) {
		//			logger.info("member2");
		//			controller = new Member2Controller();
		//			req.setAttribute("upmu", upmu); //저장하기
		//			page = controller.execute(req,resp);
		//		}
		//		if("board".equals(upmu[0])) {
		//			controller = new BoardController();
		//			req.setAttribute("upmu", upmu); //배열의 주소번지
		//			page = controller.execute(req, resp);
		//		}//내려 갈 때 전처리 코드
		if(obj!=null) {//만일 "qnaList"가 반환되었다면...참이다
			String pageMove[] = null;
			ModelAndView mav = null;
			//Object 안에는 두가지 타입이 있다 - String, ModelAndView
			if(obj instanceof String) {
				if(((String)obj).contains(":")) {
					logger.info("내 안에 콜론있어요");//JSON이 말했다 나두 :
					//콜론 있는데.. 그래 그러면 [도 있는 거야? - 응 - 당첨
					String first = obj.toString().substring(0,1);//빈깡통이면요?
					if("[".equals(first)) {
						logger.info("너 JSON이야? - 네");
						//내 안에 JSON이다 
						pageMove = new String[1];//왜냐하면 html로 내보내는게 아니니까. 방이 두개 필요없다. redirect, forward
						pageMove[0] = obj.toString();//[{"mem_id":"tomato","mem_hp":"010-555-9999"}]
					}else {
						pageMove = obj.toString().split(":");//pageMove[0]=redirect|forward, pageMove[1]=페이지이름
						logger.info(pageMove[0]+","+pageMove[1]);
					}
				}
				else if(((String)obj).contains("/")) {
					logger.info("내 안에 슬래쉬있어요");
					pageMove = obj.toString().split("/");
				}else {
					logger.info("내 안에 콜론도 없고 슬래쉬도 없어요");//qnaList
					//배열을 선언해야 한다. - 왜냐하면 그래야 일관되게 페이지 처리를 할 수 있으니까. - 이랬다가 저랬다가 하면 안되니까
					pageMove = new String[1];
					pageMove[0] = obj.toString();
					//조건문 안에서 return을 만나면 흐름이 바뀐다.
					//return; //메소드를 빠져나간다. doService를 -> 서블릿을 나간다 -> 스레드반납 
				}//end of if -> 응답문자열을 배열에 담기
			}//end of String - 컨트롤클래스의 리턴타입이 String일 때 처리기
			//너 리턴타입이 ModelAndView야? - HandlerMapping, 내 안에서 인스턴스화가 됨, 메소드 이름이 직관적임 - POJO1-2와 차이점 : 인스턴스화 하고 execute()메소드를 사용했었음 
			//ModelAndView는 스프링에서 UI{select:조회결과}를 지원하기 위해 설계되었다
			else if(obj instanceof ModelAndView) {
				mav = (ModelAndView)obj;
				pageMove = new String[2];
				//스프링에서는 리턴타입이 ModelAndView이면 페이지 경로를 WEB-INF 아래에서 찾는다
				pageMove[0]= "modelandview"; // 상수처리 : spring의 방식 모방 중
				pageMove[1] = mav.getViewName(); // boardList or memberList or noticeList
			}
			////////////////////////////////////////////////////////////////////////////////////////
			/////////////////////////////////////[[ViewResolver]]//////////////////////////////////스프링할땐 필요없는 부분
			//insert here
			//pageMove 원소의 갯수가 2개일 때 - 백엔드 처리된 결과를 화면으로 처리할 때
			//pageMove배열의 초기화는 67번 라인과 72번 라인에서 초기화 된다. - 값이 담긴다
			//78번 String이면서 세미콜론 있으나 대괄호가 없을 때
			//84번 String이면서 슬래쉬 있을 때 
		if(pageMove!=null && pageMove.length==2) {//pageMove가 채워지는 부분을 잘 봐야함
				//insert here - 스프링에서는 요청에 대한 응답 URL을 완성해 주는 ViewResolver클래스가 제공됨 
				new ViewResolver(req,resp,pageMove);
			}/////////////////////end of pageMove원소의 개수가 2개일 때///////////////////////
			//pageMove의 원소의 갯수가 1개일 때 - 화면이 아닌 경우를 처리하기 위해서 설계함 - 단순문자열이거나 JSON포맷(React 배려하는 설계임) 
			else if(pageMove!=null && pageMove.length==1) {
				logger.info("pageMove 원소의 갯수가 1개 일때");
				resp.setContentType("text/plain;charset=UTF-8");
				PrintWriter out = resp.getWriter();
				//pageMove[1]는 왜 안쓰죠? - length-1ㄱ
				out.print(pageMove[0]); //qnaList 출력한다 - 브라우저에  

			}////////////////////////end of pageMove 갯수가 1개일 때 - 화면이 아닌 문자열이나 JSON 포맷지원할 때 (spring - @RestController대신 해줌)
			else {
				logger.info("리턴결과가 JSON포맷이라서 pageMove의 갯수가 2개 이상인 경우가 나옴");
				resp.setCharacterEncoding("UTF-8");
				resp.setContentType("text/plain;charset=UTF-8");
				PrintWriter out = resp.getWriter();
				out.print(obj);
				//if문 안에서 return을 만나면 나를 감싸고 있는 메소드를 탈출한다.
				return;
			}
			//원시적인 방법 또는 레거시 시스템을 공부하는 건 자동으로 처리하다가 문제가 발생하거나 해당 프레임워크가 지원을 안해주더라도
			//표준적인 방법을 알고 있으면 해결할 수 있다.(실마리, 컨벤션, 힌트, 아이디어 제공...)
			
			/////////////////////////////////////[[ViewResolver]]/////////////////////////////////

		}//page가 null이 아니면 후처리 
	} // end of doService
	//401 - 시큐리티코딩, 인증관련 이슈
	//404 - 클라이언트가 서버에게 요청했을 때 응답으로 페이지 경로가 맞지 않거나 페이지이름이 다르면 발동
	//405 - 오버라이드 이름이 잘못되면 405번 에러 발생함
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//클래스 설계자가 정의한 메소드이다. 강제사항이 아니다.
		//사용자 정의 메소드에 파라미터를 통해서 요청객체와 응답객체의 주소번지 원본을 넘김
		//메소드를 선언할 수 있다
		//메소드의 리턴타입과 파라미터 갯수 및 타입까지도 결정할 수 있니? - 네
		//톰캣 서버로 부터 주입받은 request 객체와 response객체를 넘겨받는다 - 파라미터 자리
		//얕은복사-(원본을 바라보는 것)javascript, 깊은 복사-복사본을 만드는 것 - 새로 만든다 - 느낌  
		doService(req, resp);
		
	}
	//오버라이드 이름이 잘못되면 405번 에러 발생함 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doService(req, resp);
	}
}
