package com.example.demo.pojo2;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.HashMapBinder;

/*
 * Controller controller = new Controller(); 이건 안됨 -인터페이스는 단독으로 인스턴스화 안 됨
 * Controller controller = new OrederController(); // 생성부에 구현체 클래스가 왔음 - 합법 -> 다형성을 누릴 수 있는 전제조건
 * 
 *  질문 : 프론트 컨트롤러를 거쳐서 어떻게 OrderController의 execute메소드가 호출되나요?
 */
public class OrderController implements Controller {
	Logger logger = Logger.getLogger(OrderController.class);
	OrderLogic orderLogic = new OrderLogic();
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("execute");
		String upmu[] = (String[])req.getAttribute("upmu"); 
		String page = null;
		int result = 0;//입력,수정,삭제가 성공하면 1을 반환하고 0을 반환한다
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		if("orderList".equals(upmu[1])) {
			logger.info("orderList");//콘솔에 문자열 출력이 안되었다면 오라클 서버를 경유하지 않았다.
			List<Map<String,Object>> oList = null;
			hmb.bind(pMap);
			oList = orderLogic.orderList(pMap);
			//요청이 유지되는 동안에는 사용할 수 있다. - 조회 결과를 가진 주소번지
			//첫번째 파라미터는 문자열값이고
			//두번째 파라미터는 주소번지다
			req.setAttribute("oList", oList);
			page = "forward:order/orderList"; //-> pageMove[0]=forward, pageMove[1]=boardList.jsp
		}
		else if("orderDetail".equals(upmu[1])) {
			logger.info("orderDetail");	
			List<Map<String,Object>> oList = null;
			hmb.bind(pMap);
			oList = orderLogic.orderList(pMap);//pMap.get("b_no") => 1
			req.setAttribute("oList", oList);
			page = "forward:order/orderDetail";
		}
		//글 등록할거야? - redirect
		else if("orderInsert".equals(upmu[1])) {
			logger.info("orderInsert");
			//사용자가 입력한 값 만큼 req.getParameter가 반복되므로 이 코드를 줄여줌
			hmb.bind(pMap); //HashMapBinder의 bind메소드 호출함 - 사용자가 입력한 값을 담아줄 주소번지 넘겨줌 
			//javascript에서 제공하는 API를 사용해서 JSON다루게 됩니다.
			logger.info(pMap);//한글처리된 값 출력해 보기{키=값, 키2=값2, } -> JSON형식으로 변경처리
			//result변수는 어떤 역할이지? - 오라클 서버에 insert문 요청하면 오라클 서버가 리턴해주는 값을 담아요
			result = 0;
			result = orderLogic.orderInsert(pMap);
			if(result==1) {//입력 성공한 경우
				page = "redirect:orderList.pj2";//pj2가 붙는 이유는 오라클을 경유하니까
			}
			//실패했을 때
			else {
				page ="redirect:orderError.jsp";
			}
			
		}
		//수정하고 싶어요 - POST방식
		else if("orderUpdate".equals(upmu[1])) {
			logger.info("orderUpdate");
			hmb.bind(pMap);//사용자가 입력한 값을 담아줌
			logger.info(pMap);//확인하는 곳
			result = 0;
			result = orderLogic.orderUpdate(pMap);
			if(result==1) {//입력 성공한 경우
				page = "redirect:orderUpdate.pj2";//pj2가 붙는 이유는 오라클을 경유하니까
			}
			//실패했을 때
			else {
				page ="redirect:orderError.jsp";
			}
		}
		//이젠 삭제할게요 - redirect
		else if("orderDelete".equals(upmu[1])) {
			logger.info("orderDelete");
			hmb.bind(pMap);//사용자가 입력한 값을 담아줌
			logger.info(pMap);//확인하는 곳
			result = 0;
			//inserthere - 비교하기 전에 미리 해야한다
			result = orderLogic.orderDelete(pMap);//pMap.get("b_no")
			if(result==1) {//입력 성공한 경우
				page = "redirect:orderList.pj2";//pj2가 붙는 이유는 오라클을 경유하니까
			}
			//실패했을 때
			else {
				page ="redirect:orderError.jsp";
			}
		}
		return page;
	}

}
