<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map, java.util.ArrayList" %>     
<%
	int size = 0;
	List<Map<String,Object>> nList = (List<Map<String,Object>>)request.getAttribute("nList");
	if(nList !=null){
		size = nList.size();	
	} 
	out.print(nList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 목록</title>
</head>
<body>	
</body>
</html>