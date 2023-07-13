<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	//스크립틀릿은 자바코드의 침투가 가능한 구역
	//서버에서 이미 실행되고 그 결과가 클라이언트 측에 다운로드가 된다
	List<?> list = (List<?>)request.getAttribute("insaBean");
	//아래에서 방어코드 필요성 확인 후 작성된 부분, 메소드가 아니라 변수를 설치함 - null을 막을 수 있음 
	int size =0;
	if(list!=null){
		size=list.size();
	}
	out.print(size); //3출력
	//아래 코드에서 NullPointerException 발생할 수도 있어 - 인지
	//방어코드 필요함 
	//주소번지가 null을 참조할 수도 있다 - 기억 (null.size())
	for(int i=0;i<size;i++){//직접적으로 원인이 된 코드가 무엇인가요? - list.size() - 안심
		out.print(list.get(i));
	}
%>
</body>
</html>