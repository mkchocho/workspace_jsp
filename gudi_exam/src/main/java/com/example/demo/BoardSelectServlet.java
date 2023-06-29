package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class BoardSelectServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("BoardSelectServlet doGet");
		
		List<Map<String,Object>> bList = new ArrayList<>();
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("b_title","제목1");
		rMap.put("b_writer","고앵쓰");
		rMap.put("b_date","2023-06-25");
		bList.add(rMap);//[{b_title=제목1, b_writer=작성자1, b_date=2023-06-25}..]
		rMap=new HashMap<>();
		rMap.put("b_title","제목2");
		rMap.put("b_writer","고양쓰");
		rMap.put("b_date","2023-06-25");			
		bList.add(rMap);//[{b_title=제목1, b_writer=작성자1, b_date=2023-06-25},{b_title=제목2, b_writer=작성자2, b_date=2023-06-25}..]
		rMap=new HashMap<>();
		rMap.put("b_title","제목3");
		rMap.put("b_writer","고냠쓰");
		rMap.put("b_date","2023-06-25");
		bList.add(rMap);
		req.setAttribute("bList", bList);
		RequestDispatcher view = req.getRequestDispatcher("boardList.jsp");
		view.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost");
	}
	
}