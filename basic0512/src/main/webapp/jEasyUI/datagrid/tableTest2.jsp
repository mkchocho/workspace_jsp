<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax에서 서블릿 요청</title>
<%@ include file="../../common/easyui_common.jsp" %>
</head>
<body>
<!-- html문서는 위에서부터 차례대로 실행된다
동기적으로 처리한다 - JS 단점 - defer 속성을 사용해서 렌더링 된 후에 JS 동작 테크닉
 -->
<table id="dg"></table>
<script type="text/javascript">
// $로 된 부분이 jquery를 대신하는 기호임
// 괄호가 있으니 함수이다
// 자바스크립트에서는 함수도 객체이다
// table 태그를 가리키는 오브젝트이다.
// easyui-datagrid 오브젝트로 감싸준다.
// jEasyUI가 지원하는 CSS를 갖게 됨 
// 브라우저 동작원리-DOM Tree엔진
//Rnder Tree엔진
//위에서 읽은 돔에 CSS 붙여서 다시 그려줌

$('#dg').datagrid({
	url:"./qna.json",
    title:'QnA 게시판',
    columns:[[
        {field:'q_no', title:'글번호',width:100, align:'center'},
        {field:'q_writer', title:'작성자',width:100, align:'center'},
        {field:'q_title', title:'제목',width:100,align:'left'},
        {field:'q_date', title:'작성일',width:100,align:'left'}
    ]],
});
</script>
</body>
</html>
<!-- 
jsp액션태그 방식
xml기반의 문법
파일은 따로 관리되면서 처리결과가 한 화면에 보여짐
: 따로 *.class파일이 생성됨을 의미

@include 다이렉티브 방식
파일자체가 하나로 통합되어서 한 화면에 보여짐
이번 페이지에서는 include되는 페이지가 정적페이지에 대한 외부라이브러리이다
하나로 합쳐지는게 좋다
 -->