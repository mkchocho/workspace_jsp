<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA게시판</title>
<!--  <jsp:include page=""/> 액션태그 방식 소스가 생성됨 -->
<!-- include directive 방식에서는 소스가 하나로 합쳐짐 -->
<%@ include file="../../common/easyui_common.jsp" %>
</head>
<body>
   <table class="easyui-datagrid" title="QnA게시판" style="width:700px;height:250px"
            data-options="url:'qna.json',method:'get'">
        <thead>
            <tr>
                <th data-options="field:'q_title',width:200, align:'center'">제목</th>
                <th data-options="field:'q_writer',width:120, align:'center'">작성자</th>
                <th data-options="field:'q_content',width:400,align:'center'">내용</th>
            </tr>
        </thead>
    </table>
</body>
</html>