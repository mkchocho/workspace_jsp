<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 
html은 동기적으로 순서대로 처리한다.
읽다가 시간이 오래 걸리는 작업을 만나게 되면 응답을 받을때까지 무작정 기다린다. - 비효율적이다.
자바스크립트는 지연이 발생할 수 있다 - 체크함 - 잘한다..?
동기적인 것을 마치 비동기 인듯이 처리할 수 있다.←┘ <script defer>
DOM Tree(1)를 다 그리고 Render Tree(html태그 다 읽음 + 디자인:CSS) 그린다(브라우저)
F12 반드시 개발자 센터를 보면서 코딩하기 

 -->
<html>
<head>
<meta charset="UTF-8">
<title>QnA게시판</title>
<!--  <jsp:include page=""/> 액션태그 방식 소스가 생성됨 -->
<!-- include directive 방식에서는 소스가 하나로 합쳐짐 -->
<%@ include file="../../common/easyui_common.jsp" %>
</head>
<body>
<script type ="text/javascript">
$(document).ready(funtion(){
	console.log("돔 트리가 다 그려졌을 때");//XXX is not defined
})
</script>
   <table class="easyui-datagrid" title="QnA게시판" style="width:700px;height:250px"
            data-options="url:'/qna/jsonQnaList.pj3',method:'get'">
        <thead>
            <tr>
                <th data-options="field:'Q_TITLE',width:200, align:'center'">제목</th>
                <th data-options="field:'Q_WRITER',width:120, align:'center'">작성자</th>
                <th data-options="field:'Q_CONTENT',width:400,align:'center'">내용</th>
            </tr>
        </thead>
    </table>
</body>
</html>