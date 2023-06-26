package com.example.demo.pojo2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public class ActionServlet extends HttpServlet {
	Logger logger = Logger.getLogger(ActionServlet.class);
	// http://localhost:9000/board/boardList.pj2
	// http://localhost:9000/XXX.pj2
	protected void doService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("doService");
		String uri = req.getRequestURI(); // => /board/boardList.pj2
		logger.info(uri);
		String context = req.getContextPath(); 
		String command = uri.substring(context.length()+1);
		logger.info("context:"+context+","+"command:"+command);
		int end = command.lastIndexOf("."); 
		command = command.substring(0, end); // command = "member2/memberList" 
		logger.info("command:"+command);
		String upmu[] = null;	
		upmu = command.split("/");
		// 요청객체에다가 upmu배열의 주소번지를 저장하자
		// 왜냐하면 BoardController에서 if문으로 5가지 경우를 나눠야 한다
		Controller controller = null;
		String page = null;
		//테스트 시나리오
		//http:localhost:9000/member2/memberList.pj2
		//http:localhost:9000/member2/memberInsert.pj2
		//http:localhost:9000/member2/memberUpdate.pj2
		//http:localhost:9000/member2/memberDelete.pj2
		if("member2".equals(upmu[0])) {
			logger.info("member2");
			controller = new Member2Controller();
			//메소드이름을 가질 수는 없지만 if문으로 5가지 경우를 나눌 수 있다.
			//그래서 나는 execute메소드를 호출할 때 넘기는 request객체에다가 upmu배열을 저장한다
			req.setAttribute("upmu", upmu); //저장하기
			//오버라이드 된 execute메소드 호출하기
			//컨트롤 클래스는 Controller 인터페이스를 implements하고 있다 - 추상메소드를 재정의해야 함
			//각 컨트롤러 클래스가 서블릿이 아니어도 되는 건 execute메소드의 파라미터로 요청객체와 응답객체를 받을 수 있어서 그렇다
			page = controller.execute(req,resp);//page = "forward:member2/memberDetail"
		}
		//http:localhost:9000/board/boardList.pj2
		//http:localhost:9000/board/boardInsert.pj2
		//http:localhost:9000/board/boardUpdate.pj2
		//http:localhost:9000/board/boardDelete.pj2
		else if("board".equals(upmu[0])) {
			controller = new BoardController();
			//요청객체에 String 배열의 주소번지를 담음
			req.setAttribute("upmu", upmu); //배열의 주소번지
			//메소드 호출을 하기
			//메소드 호출할 때 첫번째 자리에 요청객체를 넘기자->왜냐면 ActionServlet에서 생성한 String[]을 BoardController에서 재사용해야 하니까..
			//request가 저장소의 역할도 가능한 건가요? - yes
			page = controller.execute(req, resp);
		}//내려 갈 때 전처리 코드
		//->http://localhost:9000/order/orderList.pj2
		//->http://localhost:9000/order/orderInsert.pj2
		//->http://localhost:9000/order/orderUpdate.pj2
		//->http://localhost:9000/order/orderDelete.pj2
		else if("order".equals(upmu[0])) {
			logger.info("주문관리");
			controller = new OrderController();//생성부의 이름으로 자바는 객체를 주입해줌  - 메모리에 로딩해줌
			//질문: execute메소드를 호출할 때 왜 upmu배열을 보내야 하나요?
			//질문: 요청객체에 담는 이유는 뭔가요? - 요청이 유지되는 동안에는 재사용이 가능함.
			//request내장객체는 동시에 저장소이기도 하다
			req.setAttribute("upmu", upmu);
			page = controller.execute(req, resp);//얕은복사 - 원본의 주소번지를 파라미터로 보냄 
		}//스프링에서라면 HandlerMapping의 역할 
		//아래 코드는 BoardController -> BoardLogic -> BoardDao 그리고 나서 실행되는 구간이 됨
		//올라올 때 후처리 코드 - 출력페이지
		//page에 담긴 문자여른 어떤 형태인가요?
		//redirect:board/boardList.jsp or forward:board/boardList.pj2
		if(page!=null) {
			String pageMove[] = null;
			//너 안에 콜론 있어? 예)redirect:board/boardList.pj2, forward:board/boardList.pj2, board/boardList.pj2 ->스프링이 지원하고 있어요
			if(page.contains(":")) {
				logger.info("내 안에 콜론있어요");
				pageMove = page.split(":");
			}else {
				logger.info("내 안에 콜론없어요");
				pageMove = page.split("/");
			}//end of if -> 응답문자열을 배열에 담기
			logger.info(pageMove[0]+","+pageMove[1]);
			//insert here - 아직 sendRedirect이나 forward에 대한 코드가 없다.
			if(pageMove != null) {//요청에 대해 응답문자열이 나왔어
				String path = pageMove[1];//page[0]-forward, page[1]-member2/memberList
				//너 안에 redirect야?
				if("redirect".equals(pageMove[0])) {
					logger.info("redirect");
					resp.sendRedirect(path);
					//아래 리턴을 반드시 붙여 줄 것 - '응답이 커밋된 후에는 forward할 수 없습니다.' 라는 오류가 발생하면 return 누락
					return;
				}
				//forward를 가진거야?
				else if("forward".equals(pageMove[0])) {
					logger.info("forward");
					// -> /memberList.jsp
					logger.info(path);
					RequestDispatcher view = req.getRequestDispatcher("/"+path+".jsp");// path = memberList
					view.forward(req, resp); 					  // "/"의 의미
				}else {
					//redirect도 없고 forward도 없어 - 스프링지원 - 수요일날 - ViewResolver
				}
			}////////////////end of 후처리///////////////////////
			
		}//page가 null이 아니면 후처리 

	} // end of doService
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doService(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doService(req, resp);
	}

}