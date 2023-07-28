package com.goodee.test;

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

public class NoticeController implements Action {
	Logger logger = Logger.getLogger(NoticeController.class);
	NoticeLogic noticeLogic = new NoticeLogic();
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("execute");
		String[] upmu = (String[])req.getAttribute("upmu");
		ActionForward af = new ActionForward();
		StringBuilder path = new StringBuilder();
		path.append("/notice/");
		boolean isRedirect = false;//ture:Redirect, false:forward
		int result = 0;//글쓰기 성공 여부, 글수정, 글삭제
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		
		//공지글쓰기
		if("noticeInsert".equals(upmu[1])) {
			logger.info("noticeInsert");
			hmb.bind(pMap);
			result = noticeLogic.noticeInsert(pMap);
			//성공
			if(result == 1) {
				path.append("noticeList.pj1");
				isRedirect = true;
			}
			//실패
			else {
				path.append("noticeError.jsp");
				isRedirect=false;
			}
		}
		
		else if("noticeList".equals(upmu[1])) {
			logger.info("noticeList");
			hmb.bind(pMap);
			List<Map<String,Object>> nList = new ArrayList<>();
			nList = noticeLogic.noticeList(pMap);//전체조회, 조건검색과 1건 검색에도 재사용 
			req.setAttribute("nList", nList);
			path.append("noticeList.jsp");//ActionForward에 path 변수에 초기화될 값
			isRedirect = false; //true이면 redirect-유지가 안 됨, false이면 forward이다-유지됨 
		}
		af.setPath(path.toString());
		af.setRedirect(isRedirect);
		return af;
}
}