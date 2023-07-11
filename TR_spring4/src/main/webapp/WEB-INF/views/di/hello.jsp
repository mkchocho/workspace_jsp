<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<% 
List<String> insa = (List)request.getAttribute("insa"); 
out.print(insa);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hello[WEB-INF]</title>
</head>
<body>
</body>
</html>