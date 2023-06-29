<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //->index.jsp?menu=home
    //->index.jsp?menu=login
    //->index.jsp?menu=info
    String menu = request.getParameter("menu");
    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TerrGYM</title>
</head>
<body>
	<table align="center" border="0" width="1100px" height="800px">
		<tr>
	<!--==================== [[ top.jsp 시작 ]] ====================-->
			<td with="1100px" height="150px">
			<%@include file="top.jsp" %>
			</td>
	<!--==================== [[ top.jsp 시작 ]] ====================-->
		</tr>
		<tr>
	<!--==================== [[ main.jsp 시작 ]] ====================-->
			<td with="1100px" height="600px">
			<%if(menu==null){%>
			<jsp:include page="main.jsp"/>
			<% } else if ("home".equals(menu)){%>
			<jsp:include page="home.jsp"/>
			<% } else if ("login".equals(menu)){%>
			<jsp:include page="login.jsp"/>
			<% } else if ("info".equals(menu)){%>
			<jsp:include page="info.jsp"/>
			<% } %>
			
			</td>
	<!--==================== [[ main.jsp 끝 ]] ====================-->
		</tr>
		<tr>
	<!--==================== [[ bottom.jsp 시작 ]] ====================-->
			<td with="1100px" height="50px">
			<%@include file="bottom.jsp" %>
			</td>
	<!--==================== [[ bottom.jsp 끝 ]] ====================-->
		</tr>
	</table>
</body>
</html>

<!--
include방식에는 두 가지가 있다.
1) include directive 방식 - 한 개 파일로 합쳐진다
2) 액션 태그방식 - 각각 파일로 존재하면서 처리된 결과만 포함시켜서 출력된다.
-->
<!-- 
D:\eclipse\workspace_jsp\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\gudi_exam\org\apache\jsp\template

이 폴더 안에 있는 .java, .class 파일들 모두삭제 후
주소창에 http://localhost:9000/gudi_exam/template/index.jsp 엔터

메뉴를 누르지 않고 위 url로 접속만 했을 때 index와 main에 대한 파일들만 생성됨
top과 bottom에 대한 파일들은 보이지 않음
< % @include file % > 방식으로 import되어 합쳐졌기 때문임
 -->
