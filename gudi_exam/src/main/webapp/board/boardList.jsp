<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Map, java.util.List, java.util.ArrayList" %>  
    <!-- 
    	jsp에는 자바코드를 최소한으로 적는다
    	왜냐면 jsp파일은 인스턴스화 할 수 없다 -> 의존성 주입, IoC, 이른 인스턴스화, 게으른 인스턴스화
    	인스턴스화를 할 수 없으면 그 클래스가 소유하고 있는 변수나 메서드를 호출 할 수 없다
    	재사용할 수 없다 = 누릴 수 없다
    	JSP는 서블릿이지만 클래스 이름이 WAS마다 달라지므로 인스턴스화가 불가함
    	최소한의 자바코드는 데이터셋(List<Map<>>, List<XXXVO>)에 관련된 것만 적는것이 좋다
    	JSp는 응답페이지로 역할을 수행하면 족하다
    	html, css, js, java 섞어쓰기가 가능함
    	그렇지만 정적페이지에 비중을 더 둔다
    	MVC패턴을 적용한 개발 방법론이 더 좋다
    	업무 분장, 재사용성을 높임, 유지보수 유리
    	단점은 클래스가 여러 개로 쪼개져 있어서 적정한 시점에 적절한 객체를 주입하는 것이 쉽지 않다
    	NullPointerException, ClassCastingException, NumberFormatException...
    	위와 같은 예외상황을 예방할 수 있다면...
    	어떻게 하면 위와 같은 문제를 피할 수 있나? -> Spring
    	프레임워크가 개발자가 직접 인스턴스화 하는 것을 대신 해줌
    	대신 해주는데 단 제약조건이 있다
    	업무와 업무 사이에는 관계가 있다 - 객체 주입을 잘 해줘야 함 - 스프링이 해줌
    	spring-context.jar -> ApplicationContext 빈관리해주는 객체 제공함
    	spring-bean.jar -> BeanFactory 빈관리해주는 객체 제공됨
    	jar안에 들어있는 클래스 묶음들을 스프링 컨테이너라고 함
    	
    	데이터셋은 어디에서 가져오나? -> BoardWriteServlet, BoardSelectServlet, BoardUpdateServlet, BoardDeleteServlet
    	하나로 할 수는 없나?
    	하나로 하기 위해서는 메서드가 필요하다
    	사용할 수 있는 메서드는 2개뿐 -> doGet, doPost
    	업무적인 depth가 깊을수록 필요한 메서드 갯수는 10개, 20개, 30개 늘어남
    	그런데 이런 메서드는 파라미터로 반드시 request와 response가 있어야함 - 주입받아야 함
    	웹서비스 제공 -> 그러니까 표준이 필요함 
     -->
 <%
	 //스크립틀릿-서버에서 실행하고 그 결과만 받아오는 부분->html보다 가장 먼저 실행됨
	 //즉 화면이 그려지기 전에 이미 결정되어 있다.
	 //서버로부터 브라우저로 이미 다운로드 됨
	 //코딩 위치는 상관없이 가장 먼저 실행됨-단 선언이 먼저이므로 앞에 적어야함
	 List<Map<String, Object>> bList = (List)request.getAttribute("bList");//왜냐면 오라클 서버에서 가져와야해서 null
	 	if(bList==null){
	 		 bList = new ArrayList<>();
		 }
	 out.print(bList);//[]빈덩어리만 출력=오라클을 경유하지 않았기때문에
	//List=[], Map={}형태로 출력됨
	//List<Map<>> -> [ {,,}, {,,}.. ]={}은 Map(컬럼)의 갯수만큼 출력
 %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록 보기</title>
</head>
<body>
	<table border="1">
<!-- 테이블 헤더 -->
		<tr>
			<th>제목</th><th>작성자</th><th>작성일</th>
		</tr>
<%
	for(int i=0; i<bList.size(); i++){//여기는 왜 NullPointerException이 아닌가
		Map<String,Object> rmap = bList.get(i);
%>
		<tr>
			<td><%=rmap.get("b_title") %></td>
			<td><%=rmap.get("b_writer") %></td>
			<td><%=rmap.get("b_date") %></td>
		</tr>
<%
	}
%>		
	</table>
</body>
</html>