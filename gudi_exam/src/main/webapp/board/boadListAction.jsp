<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map, java.util.ArrayList"%>
<%@ page import="java.util.HashMap"%>    
<%
	List<Map<String,Object>> bList = new ArrayList<>();
	Map<String, Object> rMap = new HashMap<>();
	rMap.put("b_title","제목1");
	rMap.put("b_writer","작성자1");
	rMap.put("b_date","2023-06-25");
	bList.add(rMap);//[{b_title=제목1, b_writer=작성자1, b_date=2023-06-25}..]
	rMap=new HashMap<>();
	rMap.put("b_title","제목2");
	rMap.put("b_writer","작성자2");
	rMap.put("b_date","2023-06-25");			
	bList.add(rMap);//[{b_title=제목1, b_writer=작성자1, b_date=2023-06-25},{b_title=제목2, b_writer=작성자2, b_date=2023-06-25}..]
	rMap=new HashMap<>();
	rMap.put("b_title","제목3");
	rMap.put("b_writer","작성자3");
	rMap.put("b_date","2023-06-25");
	bList.add(rMap);
	request.setAttribute("bList", bList);
	RequestDispatcher view = request.getRequestDispatcher("boardList.jsp");
	view.forward(request, response);
%>