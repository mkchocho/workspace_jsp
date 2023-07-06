<%
//공통코드는 도메인이 바뀐다
//경로가 달라진다 - 절대경로와 상대경로
//server.xml 등록된 <Context path> 값을 가져오는 메소드 입니다.
	StringBuilder path = new StringBuilder(request.getContextPath());
	path.append("/");
%>   
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=path.toString() %>themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path.toString() %>demo/demo.css">
<link rel="stylesheet" type="text/css" href="<%=path.toString() %>themes/icon.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.js"></script>