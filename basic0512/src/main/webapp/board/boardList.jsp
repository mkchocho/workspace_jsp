<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map, java.util.ArrayList" %>        
<%
	//스크립틀릿 - 지변, 메소드선언 불가함, 인스턴스화 가능함
	int size = 0;//지변이니까 초기화를 생략하면 에러발생함.
	List<Map<String,Object>> bList = (List<Map<String,Object>>)request.getAttribute("bList");
	//nList가 null이 아니기 위해서는 테스트 시나리오를 어떻게 가져가야 할까?
	//경우의 수 : 한 건도 등록되지 않았을 때 - 0 -myBatis에서 간섭(인터셉트) nList = new ArrayList<>();
	if(bList !=null){
		size = bList.size();	
	} 
	out.print(bList);//[{},{},{}] -> JSON 포맷 - 하이브리드앱에서도 서비스 가능하니까...
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판목록</title>
</head>
<body>
	<h2>게시판 목록보기</h2>
</body>
</html>