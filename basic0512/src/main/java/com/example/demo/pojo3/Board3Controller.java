package com.example.demo.pojo3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

public class Board3Controller implements Controller3 {
	Logger logger = Logger.getLogger(Board3Controller.class);
	//이른 인스턴스화 라 함
	//개발자가 직접 인스턴스화를 한다는 건 객체관리도 내가 하겠다는 의미임
	//이런 경우는 역제어, 제어역전이라고 하지않음
	Board3Logic boardLogic = new Board3Logic();
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

	@Override
	public Object kakaoCallback(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object jsonQnaList(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object qnaList(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object qnaDetail(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object qnaInsert(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object qnaUpdate(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object qnaDelete(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//아래 메소드를 호출할 수 있는 URL은 무엇입니까?
	//->http://localhost:9000/board3/boardList.pj3
	//1-1과 1-2번에서는 정해진 하나의 메소드(execute(req,res))만 req와 res를 가질 수 있었다.
	//그런데 여기서는 사용자 정의 메소드도 요청객체와 응답객체를 갖게 되었다. - 이걸 설명해 보세요..
	@Override
	public ModelAndView boardList(HttpServletRequest req, HttpServletResponse res) {
		logger.info("boardList");
		List<Map<String,Object>> bList = null;
		bList = boardLogic.boardList();
		ModelAndView mav = new ModelAndView(req);
		//아래에서 화면이름을 줄때 뒤에 .jsp를 붙이면 안된다
		//왜냐하면 접두어가 WEB-INF/views가 붙고
		//화면이름.jsp가 붙는다g
		// -> WEB-INF/views/board3/boardList.jsp.jsp > .jsp가 두번 붙으면 안됨
		mav.setViewName("board3/boardList");
		return mav;
	}
	
	@Override
	public String jsonBoardList(HttpServletRequest req, HttpServletResponse res) {
		logger.info("boardList");
		List<Map<String,Object>> bList = null;
//		bList = boardLogic.boardList();
		bList = new ArrayList<Map<String,Object>>();
		Map<String,Object> rmap = new HashMap<String, Object>();
		rmap.put("b_no",1);
		rmap.put("b_title","제목1");
		rmap.put("b_content","내용1");
		bList.add(rmap);
		rmap=new HashMap<String, Object>();
		rmap.put("b_no",2);
		rmap.put("b_title","제목2");
		rmap.put("b_content","내용2");
		bList.add(rmap);
		rmap=new HashMap<String, Object>();
		rmap.put("b_no",3);
		rmap.put("b_title","제목3");
		rmap.put("b_content","내용3");
		bList.add(rmap);
		logger.info(bList);//여기서는 그냥 String이 출력 됨. 그래서 =연산자가 있다.
		Gson g = new Gson();
		String temp=g.toJson(bList);
		//그러나 아래서는 :이 들어간다. 왜냐면 JSON 포맷으로 변경되었으니까...
		logger.info(temp);
		return temp;
	}


}
