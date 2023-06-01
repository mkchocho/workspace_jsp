package com.example.demo.pojo1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.HashMapBinder;
//나는 서블릿이 아니어도 좋다 왜냐하면 FrontMVC로 부터 원본을 넘겨받으면 되니까... 얕은복사
//로그 출력하기 - 공통된 관심사
/*
 * 서블릿(FrontMVC)과 Java(NoticeController)클래스를 연결하기
 * 1. NoticeController가 서블릿이 아니면서도 request와 response 누릴 수 있다. (how)
 * Action인터페이스의 추상메소드 execute를 활용(파라미터로)해서... 얕은복사(javascript 키워드)
 * 2. doGet이나 doPost에서 return 타입이 void인 것을 ActionForward로 바꾸어 본다.(자바기초, 코딩경험들...)
 * :서블릿은 HttpServlet 상속 받아야 해서 오버라이드 관계인 메소드는 반드시 리턴타입이 void임
 * 3. 알고리즘보다는 자바코드를 가지고 변화를 주는 것 부터 시작해 보기 
 * :리턴타입을 굳이 바꿔본다
 * :파라미터 타입도 바꾸어보자
 * :생성자를 활용해 본다(static 대신에...)
 */
public class NoticeController implements Action {
	Logger logger = Logger.getLogger(NoticeController.class);
	//선언부는 타입을 생성부는 생성자호출 - 생성자를 모르면 static(메모리 에러원인)자꾸만 쓴다
	//이른(미리) 인스턴스화 라고 한다 (<->게으른 인스턴스화: 필요한 시점에 그때 인스턴스화 하기)
	NoticeLogic noticeLogic = new NoticeLogic();//new다음이 생성자 호출하는 문장
	//게으른 인스턴스화는 선언과 생성을 따로 하는 것 
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("execute");
		//FrontMVC 서블릿으로부터 execute메소드를 호출할 때 파라미터로 요청객체와 응답객체를 받아온다.
		String[] upmu = (String[])req.getAttribute("upmu");
		ActionForward af = new ActionForward();
		StringBuilder path = new StringBuilder();
		path.append("/notice/");
		boolean isRedirect = false;//ture:Redirect, false:forward
		//입력, 수정, 삭제는 리턴값이 1 또는 0 이다.
		int result = 0;//글쓰기 성공 여부, 글수정, 글삭제
		//insert here
		//사용자가 화면에서 입력한 값을 담을 맵 생성하기 -> 왜 선언만 하지 않고 new까지를 썼나?
		Map<String,Object> pMap = new HashMap<>();//여기선 선언만 되었으니까...
		//실제 반복되는 코드를 줄여주는 bind메소드 소유주 선언하고 생성(생성자 호출)하기
		//왜 생성자에 request를 썼나요?-bind 메소드 안에서 req.getParameter("이름") 이 코드가 반복문 안에 필요함
		//난 서블릿이 아닌데 request가 필요해
		//생성자로 받은 변수는 지변(메소드 안에서만 유지)이고 따라서 bind메소드에서 사용이 불가함
		//생성자 안에서 반드시 전변으로 선언한 변수에 대입연산자로 초기화 할 것.
		HashMapBinder hmb = new HashMapBinder(req);
		
		//공지글쓰기
		if("noticeInsert".equals(upmu[1])) {
			logger.info("noticeInsert");
			hmb.bind(pMap);
			result = noticeLogic.noticeInsert(pMap);
			//성공했어?
			if(result == 1) {
				path.append("noticeList.pj1");//이게 좀 어렵다...
				isRedirect = true;
			}
			//실패했는데..
			else {
				path.append("noticeError.jsp");
				isRedirect=true;
			}
		}
		//공지글 수정
		else if("noticeUpdate".equals(upmu[1])) {
			logger.info("noticeUpdate");
			hmb.bind(pMap);
			result = noticeLogic.noticeUpdate(pMap);
			//성공했어?
			if(result == 1) {
				path.append("noticeList.pj1");//이게 좀 어렵다...
				isRedirect = true;
			}
			//실패했는데..
			else {
				path.append("noticeError.jsp");
				isRedirect=true;
			}

		}
		//공지글 삭제
		else if("noticeDelete".equals(upmu[1])) {
			logger.info("noticeDelete");
			hmb.bind(pMap);
			result = noticeLogic.noticeDelete(pMap);
			//성공했어?
			if(result == 1) {
				path.append("noticeList.pj1");//이게 좀 어렵다...
				isRedirect = true;
			}
			//실패했는데..
			else {
				path.append("noticeError.jsp");
				isRedirect=true;
			}

		}
		//공지글 조회
		else if("noticeList".equals(upmu[1])) {
			logger.info("noticeList");
			//사용자가 입력한 값을 pMap에 담아줌 - gubun, keyword
			hmb.bind(pMap);
			//오라클 서버로 부터 select한 결과를 받음
			List<Map<String,Object>> nList = new ArrayList<>();
			nList = noticeLogic.noticeList(pMap);//전체조회, 조건검색과 1건 검색에도 재사용 
			req.setAttribute("nList", nList);
			path.append("noticeList.jsp");//ActionForward에 path 변수에 초기화될 값
			isRedirect = false; //true이면 redirect-유지가 안 됨, false이면 forward이다-유지됨 
		}
		//공지글 상세보기 - 1건만 가져오기(사용자가 하나를 선택해야함-n_no), noticeList와 메소드를 공유가능함
		else if("noticeDetail".equals(upmu[1])) {
			logger.info("noticeDetail");
			//사용자와 소통하기
			hmb.bind(pMap);
			List<Map<String,Object>> nList = new ArrayList<>();
			//전체조회와 같은 이름의 메소드를 호출해요-왜냐면 myBatis는 동적쿼리를 지원하니까...
			nList = noticeLogic.noticeList(pMap);
			path.append("noticeDetail.jsp");
			isRedirect = false;//true이면 redirect, false이면 forward
			

		}
		//insert here
		//80,81번에서 결정된 값을 ActionForward의 전변에 담기 - 메소드를 사용한 이유는 private이라서...
		//setter메소드의 파라미터로 결정된 값을 넘겨서 private으로 선언된 변수에 대신 담아줌
		//getter는 읽기, setter는 쓰기,저장
	
		af.setPath(path.toString());
		af.setRedirect(isRedirect);
		return af;
	}
}
