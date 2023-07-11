<%@ page language="java" contentType="application/json; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map, java.util.ArrayList, java.util.HashMap, com.google.gson.Gson"%>
<%
List<Map<String, Object>> qList = new ArrayList<>();
Map<String, Object> pmap = new HashMap<>();
pmap.put("q_no",3);
pmap.put("q_writer","나최고");
pmap.put("q_title","제목3");
qList.add(pmap);
pmap = new HashMap<>();
pmap.put("q_no",2);
pmap.put("q_writer","나부자");
pmap.put("q_title","제목2");
qList.add(pmap);
pmap = new HashMap<>();
pmap.put("q_no",1);
pmap.put("q_writer","나일등");
pmap.put("q_title","제목1");
qList.add(pmap);
Gson g = new Gson();
String temp = g.toJson(qList);
out.print(temp);
%>