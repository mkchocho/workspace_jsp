<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map, java.util.ArrayList" %>        
<%@ page import="com.util.BSPageBar" %>        
<%
	//스크립틀릿 - 지변, 메소드선언 불가함, 인스턴스화 가능함
	int size = 0;//지변이니까 초기화를 생략하면 에러발생함.
	List<Map<String,Object>> qList = (List<Map<String,Object>>)request.getAttribute("qList");
	if(qList !=null){
		size = qList.size();	
	}
	int numPerPage = 5;
	int nowPage = 0;
	if(request.getParameter("nowPage")!=null){
		nowPage = Integer.parseInt(request.getParameter("nowPage"));
	}
	//out.print(size);//0이 출력됨
	out.print(qList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA게시판[WEB-INF]</title>
<%@include file="/common/bootstrap_common.jsp"%>
<link rel="stylesheet" href="/css/qna.css">
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript">
	const qnaList = () => {
		//alert('qnaList');
		location.href="/qna/qnaList.pj3";
	}
	const qnaDetail = (q_no) => {
		console.log('qnaDetail 사용자가 선택한 글번호 : '+q_no);
		location.href="/qna/qnaDetail.pj3?q_no="+q_no;
	}
	const qnaSearch = () => {
	    const gubun = document.querySelector('#gubun').value;
	    const keyword = document.querySelector('#keyword').value;
	    console.log(gubun+", "+keyword);
	    window.location.href="/qna/qnaList.pj3?gubun="+gubun+"&keyword="+keyword;   			
	}
	const searchEnter = (event) => {
		console.log(window.event.keyCode);
		if(window.event.keyCode == 13){
			qnaSearch();
		}
	}
	const qnaInsert = () => {
		document.querySelector("#f_qna").submit();
	}
	const zipcodeSearch = () => {
		
	}
	//자식창에서 부모창 함수 호출하기
	window.call = function(zipcode, address){
		console.log('자식창에서 호출 : '+ zipcode+', '+address);
		document.querySelector('#mem_zipcode').value=zipcode;
		document.querySelector('#mem_address').value=address;
	}
	const zipcodeForm = () => {
		cmm_window_popup('zipcodeSearch.jsp','700','600','zipcodeForm');
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
			<h2>QnA게시판 <small>글목록</small></h2>
			<hr />
		</div>
		<!-- 검색기 시작 -->
		<div class="row">
			<div class="col-3">
		    	<select id="gubun" class="form-select" aria-label="분류선택">
		      		<option value="none">분류선택</option>
		      		<option value="q_title">제목</option>
		      		<option value="q_writer">작성자</option>
		      		<option value="q_content">내용</option>
		    	</select>			
		  	</div>
			<div class="col-6">
		 		<input type="text" id="keyword" class="form-control" placeholder="검색어를 입력하세요" 
		           aria-label="검색어를 입력하세요" aria-describedby="btn_search" onkeyup="searchEnter()"/>
			</div>
			<div class="col-3">
		 		<button id="btn_search" class="btn btn-danger" onClick="qnaSearch()">검색</button>
		 	</div>
		</div>		
		<!-- 검색기 끝 -->
		
		<!-- 회원목록 시작 -->
		<div class='qna-list'>
			<table class="table table-hover">
		    	<thead>
		      		<tr>
		        		<th width="10%">#</th>
		        		<th width="50%">제목</th>
		        		<th width="20%">작성자</th>
		        		<th width="20%">조회수</th>
		      		</tr>
		    	</thead>
		    	<tbody>
<%
	//for(int i=0;i<size;i++){
	for(int i=nowPage*numPerPage;i<(nowPage*numPerPage)+numPerPage;i++){
		if(size == i) break;
		Map<String,Object> rmap = qList.get(i);
%>		    	
		      		<tr>
		        		<th><%=rmap.get("Q_NO") %></th>
		        		<th><a href="javascript:qnaDetail('<%=rmap.get("Q_NO")%>')"><%=rmap.get("Q_TITLE") %></a></th>
		        		<th><%=rmap.get("Q_WRITER") %></th>
		        		<th><%=rmap.get("Q_HIT") %></th>
		      		</tr>
<%
	}
%>		      		
		    	</tbody>
			</table> 
    
<hr />  
<!-- [[ Bootstrap 페이징 처리  구간  ]] -->
	<div style="display:flex;justify-content:center;">
	<ul class="pagination">
<%
	String pagePath = "qnaList.pj3";
	BSPageBar bspb = new BSPageBar(numPerPage, size, nowPage, pagePath);
	out.print(bspb.getPageBar());
%>
	</ul>
	</div>
<!-- [[ Bootstrap 페이징 처리  구간  ]] -->		  
		  	<div class='qna-footer'>
		    	<button class="btn btn-warning" onclick="qnaList()">
		      		전체조회
		    	</button>&nbsp; 
			    <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#qnaForm">
			    글쓰기
			    </button>
		    </div>
		</div>		
		<!-- 회원목록   끝  -->		
		
	</div>
	<!-- body end       -->
	<!-- footer start -->
	<%@include file="/include/gym_footer.jsp"%>
	<!-- footer end    -->	
	<!-- ========================== [[ QnA게시판 Modal ]] ========================== -->
	<div class="modal" id="qnaForm">
	  <div class="modal-dialog modal-dialog-centered">
	    <div class="modal-content">
	
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h4 class="modal-title">QnA게시판</h4>
	        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
	      </div>
	      <!-- Modal body -->
	      <div class="modal-body">
	      	<form class="form-inline" id="f_qna" method="post" action="./qnaInsert.pj3">
	          <div class="input-group mb-2">
		            <label class="input-group-text" for="q_title">제목</label>
	            	<input type="text" class="form-control" id="q_title" name="q_title" placeholder="Enter 제목" />
	          </div>	      	
	          <div class="input-group mb-2">
	            <label class="input-group-text"  for="q_writer">작성자</label>
	            <input type="text"  class="form-control" id="q_writer" name="q_writer" placeholder="Enter 작성자"/>
	          </div>	      	
	          <div class="input-group mb-2">
	            <label class="input-group-text"  for="q_content">내용</label>
	            <textarea rows="5" class="form-control h-25" aria-label="With textarea" id="q_content" name="q_content"></textarea>
	          </div>	      	
	      	</form>
	      </div>	
	      <div class="modal-footer">
	        <input type="button" class="btn btn-warning" data-bs-dismiss="modal" onclick="qnaInsert()"  value="저장">
	        <input type="button" class="btn btn-danger" data-bs-dismiss="modal" value="닫기">
	      </div>
	
	    </div>
	  </div>
	</div>
    <!-- ========================== [[ 게시판 Modal ]] ========================== -->				
</body>
</html>
<!-- 

select * from qna;

CREATE TABLE MBLOG.board230527
(
  b_no      NUMBER(5) constraints board230527_no_pk primary key,
  b_TITLE    VARCHAR2(100 BYTE),
  b_writer varchar2(30),
  b_CONTENT  VARCHAR2(4000 BYTE),
  b_HIT      NUMBER(5),
  b_DATE     VARCHAR2(20 BYTE)
);

SELECT * FROM board230527;

edit board230527;
SELECT seq_board230527_no.nextval FROM dual;

- M/P 의 의미

       - M : Margin을 의미

       - P : Padding을 의미

- t , b , l , r ,x , y  의 의미

       - t : top을 의미 

       - b : bottom을 의미

       - l : left을 의미

       - r : right을 의미

       - x : x축 -> left , right을 의미

       - y : y축 -> top , bottom을 의미

- 0, 1, 2, 3, 4, 5, auto  의 의미

       - 0 : 0

       - 1 : .25rem( font-size가 16px이면, 4px) 크기

       - 2 : .5rem( font-size가 16px이면, 8px) 크기

       - 3 : 1rem( font-size가 16px이면, 16px) 크기

       - 4 : 1.5rem( font-size가 16px이면, 24px) 크기

       - 5 : 3rem( font-size가 16px이면, 48px) 크기

       - auto : margin의 자동으로 세팅

- 0, 1, 2, 3, 4, 5, auto  의 의미

       - 0 : 0

       - 1 : .25rem( font-size가 16px이면, 4px) 크기

       - 2 : .5rem( font-size가 16px이면, 8px) 크기

       - 3 : 1rem( font-size가 16px이면, 16px) 크기

       - 4 : 1.5rem( font-size가 16px이면, 24px) 크기

       - 5 : 3rem( font-size가 16px이면, 48px) 크기

       - auto : margin의 자동으로 세팅

- n1, n2, n3, n4, n5 의 의미 

   - n : negative을 의미

       - n1 : -.25rem( font-size가 16px이면, -4px) 크기

       - n2 : -.5rem( font-size가 16px이면, -8px) 크기

       - n3 : -1rem( font-size가 16px이면, -16px) 크기

       - n4 : -1.5rem( font-size가 16px이면, -24px) 크기

       - n5 : -3rem( font-size가 16px이면, -48px) 크기
 -->