<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,java.util.Map,java.util.ArrayList,java.util.HashMap" %>
<%@ page import ="com.google.gson.Gson" %>
<%
	List<Map<String,Object>> list = new ArrayList<>();
	Map<String,Object> rmap = new HashMap<>();
	rmap.put("deptno",10);
	rmap.put("dname","개발1팀");
	rmap.put("loc","서귀포");
	list.add(rmap);//간접참조방식이다. - 주소번지를 두 번 접근해야만 데이터값을 볼 수 있음
	
	rmap = new HashMap<>();//새로운 주소번지 할당 됨
	rmap.put("deptno",20);
	rmap.put("dname","운영팀");
	rmap.put("loc","포항");
	list.add(rmap);

	rmap = new HashMap<>();//새로운 주소번지 할당 됨
	rmap.put("deptno",30);
	rmap.put("dname","QC팀");
	rmap.put("loc","서울");
	list.add(rmap);
	Gson g = new Gson();
	String temp = g.toJson(list);
	out.print(temp);
	
%>
