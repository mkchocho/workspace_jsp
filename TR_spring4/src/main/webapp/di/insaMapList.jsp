<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% 
    Map<String,Object> rmap = (Map)request.getAttribute("insaMapBean");
    out.print(rmap);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	//직접 체험할 수 있도록 연습 
	//자기 생각을 코드로 표현하는데 필요한 API 중심으로 코딩 전개
	//자바API기준으로 ㅋ됭을 전개 - 표준 - 직접판단해보기
	//두 번의 메소드를 연속하여 호출해서 필요한 객체를 주입함 - 풍성해졌다 
	Object keys[] = rmap.keySet().toArray(); //공통팀(공통코드, 형상관리(팀)-git-버전관리-history)
	for(Object obj:keys){
		String key = (String)obj;
		out.print(key);
	}
%>
</body>
</html>