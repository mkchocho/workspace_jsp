<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<%@include file="/common/bootstrap_common.jsp"%>
<link rel="stylesheet" href="/css/notice.css">
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript">
const noticeList = () => {
	location.href="/testChoMinkyo/notice/noticeList.jsp";//location 앞에 window. 생략 
}
</script>
</head>
<body>
	<!-- body start    -->
	<div class="container">
		<div class="page-header">
			<h2>공지사항 <small>공지목록</small></h2>
			<hr />
		</div>
		<!-- 검색기 시작 -->
		<div class="row">
			<div class="col-3">
		    	<select id="gubun" class="form-select" aria-label="분류선택">
		      		<option value="none">분류선택</option>
		      		<option value="n_title">제목</option>
		      		<option value="n_writer">작성자</option>
		      		<option value="n_content">내용</option>
		      		<option value="n_date">작성일</option>
		      		<option value="n_no">공지번호</option>
		    	</select>			
		  	</div>
			<div class="col-6">
		 		<input type="text" id="keyword" class="form-control" placeholder="검색어를 입력하세요" 
		           aria-label="검색어를 입력하세요" aria-describedby="btn_search" onkeyup="searchEnter()"/>
			</div>
			<div class="col-3">
		 		<button id="btn_search" class="btn btn-danger" onClick="noticeSearch()">검색</button>
		 	</div>
		</div>		
		<!-- 검색기 끝 -->
		
		<!-- 회원목록 시작 -->
		<div class='notice-list'>
			<table class="table table-hover">
		    	<thead>
		      		<tr>
		        		<th width="10%">공지번호</th>
		        		<th width="50%">제목</th>
		        		<th width="20%">작성자</th>
		        		<th width="20%">작성일</th>
		      		</tr>
		    	</thead>
		    	<tbody>
		      		<tr>
		        		<td width="10%" align="center">125</td>
		        		<td width="50%" align="left">운동법 공유</td>
		        		<td width="20%" align="left">회원1</td>
		        		<td width="20%" align="left">2023-07-25</td>
		      		</tr>
	      		</tbody>
		    	<tbody>
		      		<tr>
		        		<td width="10%" align="center">124</td>
		        		<td width="50%" align="left">회원등록 안내</td>
		        		<td width="20%" align="left">관장</td>
		        		<td width="20%" align="left">2023-07-24</td>
		      		</tr>
		    	</tbody>
		    	<tbody>
		      		<tr>
		        		<td width="10%" align="center">123</td>
		        		<td width="50%" align="left">보수공사 시행안내</td>
		        		<td width="20%" align="left">관리사무소</td>
		        		<td width="20%" align="left">2023-07-23</td>
		      		</tr>
		    	</tbody>
			</table> 
    	
<hr />  
		  	<div class='notice-footer'>
		    	<button class="btn btn-warning" onclick="noticeList()">
		      		전체조회
		    	</button>&nbsp; 
			    <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#noticeForm">
			    글쓰기
			    </button>
		    </div>
		</div>		
		<!-- 회원목록   끝  -->		
		
	</div>
	<!-- body end       -->
	<!-- ========================== [[ 공지사항 Modal ]] ========================== -->
	<div class="modal" id="noticeForm">
	  <div class="modal-dialog modal-dialog-centered">
	    <div class="modal-content">
	
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h4 class="modal-title">공지사항</h4>
	        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
	      </div>
	      <!-- Modal body -->
	      <div class="modal-body">
	      <!-- form전송하기 {method, action=""} -->
	      	<form id="f_notice" method="get" action="./noticeInsert.pj1">
	          <div class="form-floating mb-3 mt-3">
	            <input type="text"  class="form-control" id="n_title" name="n_title" placeholder="Enter 제목" />
	            <label for="n_title">제목</label>
	          </div>	      	
	          <div class="form-floating mb-3 mt-3">
	            <input type="text"  class="form-control" id="n_writer" name="n_writer" placeholder="Enter 작성자" />
	            <label for="n_writer">작성자</label>
	          </div>	      	
	          <div class="form-floating mb-3 mt-3">
	            <textarea rows="5" class="form-control h-25" aria-label="With textarea" id="n_content" name="n_content"></textarea>
	          </div>	      	
	      	</form>
	      </div>	
	      <div class="modal-footer">
	        <input type="button" class="btn btn-warning" data-bs-dismiss="modal" onclick="noticeInsert()"  value="저장">
	        <input type="button" class="btn btn-danger" data-bs-dismiss="modal" value="닫기">
	      </div>
	
	    </div>
	  </div>
	</div>
    <!-- ========================== [[ 공지사항 Modal ]] ========================== -->				
</body>
</html>