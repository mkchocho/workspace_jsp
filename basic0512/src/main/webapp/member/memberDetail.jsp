<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List, java.util.Map" %>
    <%
    //html소스와 자바코드를 섞어쓰기 할 때에 당분간은 맨 앞쪽에 위치한다
    //대체로는 상관이 없다 - 왜냐하면 여기에 적힌 자바코드는 이미 톰캣서버에서 실행되고
    //결정이 끝난 상태에서 그 결과가 다운로드 되기 때문에 그렇다
     int size = 0;// 지변이니까 초기화를 생략하면 에러발생함
    List<Map<String,Object>> mList = (List<Map<String,Object>>)request.getAttribute("mList");
    Map<String, Object> rmap = null;
    if(mList !=null) {
      size = mList.size();// 3	
      rmap = mList.get(0); //파라미터는 존재한다면 0일 것이다. - 왜냐면 조회가 되더라도 한 건일 테니까...
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<%@include file="/common/bootstrap_common.jsp"%>
<script type = "text/javascript">
const memberDelete = () => {
	location.href="./memberCRUD?method=memberDelete&mem_no=<%=rmap.get("mem_no")%>";
}
</script>
</head>
<body>
	<!-- header start -->
	<%@include file="/include/gym_header.jsp"%>
	<!-- header end    -->
	<!-- body start    -->
	<div class="container">
		<div class="page-header">
			<h2>회원관리 <small>회원상세</small></h2>
			<hr />
		</div>
		
		<!-- 회원목록 시작 -->


	      <div style="width:58rem;">
	        <div class="card-body">
	          <div class='book-detail'>
	            <div class='book-header'>
	              <h5 class="card-title"><%=rmap.get("mem_name") %></h5>
	              <p class="card-text"><%=rmap.get("mem_id") %></p>
	            </div>
	          </div>
	        </div>
	        <ul class=" list-group list-group-flush">
	          <li class="list-group-item"><%=rmap.get("mem_zipcode") %></li>
	          <li class="list-group-item"><%=rmap.get("mem_address") %></li>
	        </ul>
	        <div class='detail-link'>
	          <button class="btn btn-info" onclick="memberDelete()">
	          수정
	          </button>
	          &nbsp;
	          <button class="btn btn-warning" onclick="memberDelete()">
	            삭제
	          </button>
	          &nbsp;
	          <button class="btn btn-success" onclick="memberList()">
	          회원목록
	          </button>
	        </div>
	      </div>  
		
		<!-- 회원목록   끝  -->		
		
	</div>
	<!-- body end       -->
	<!-- footer start -->
	<%@include file="/include/gym_footer.jsp"%>
	<!-- footer end    -->	
</body>
</html>