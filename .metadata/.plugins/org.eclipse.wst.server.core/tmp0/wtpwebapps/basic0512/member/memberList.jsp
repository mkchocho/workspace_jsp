<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map, java.util.ArrayList" %>        
<%
    //스크립틀릿 - 지변, 메소드선언 불가함, 인스턴스화 가능함
    int size = 0;//지변이니까 초기화를 생략하면 에러발생함.
    List<Map<String,Object>> mList = (List<Map<String,Object>>)request.getAttribute("mList");
    out.print(size);//0이 출력됨
    out.print(mList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<%@include file="/common/bootstrap_common.jsp"%>
<link rel="stylesheet" href="/css/member.css">
<script type="text/javascript">
    const handleShow = () => {
       
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
          <h2>회원관리 <small>회원목록</small></h2>
          <hr />
       </div>
       <!-- 검색기 시작 -->
       <div class="row">
          <div class="col-3">
              <select id="gubun" class="form-select" aria-label="분류선택">
                 <option defaultValue>분류선택</option>
                 <option value="mem_id">아이디</option>
                 <option value="mem_name">이름</option>
                 <option value="mem_address">주소</option>
              </select>        
          </div>
          <div class="col-6">
             <input type="text" id="keyword" class="form-control" placeholder="검색어를 입력하세요" 
                  aria-label="검색어를 입력하세요" aria-describedby="btn_search" />
          </div>
          <div class="col-3">
             <button id="btn_search" class="btn btn-danger" onClick="memberSearch()">검색</button>
          </div>
       </div>    
       <!-- 검색기 끝 -->
       
       <!-- 회원목록 시작 -->
       <div class='member-list'>
          <table class="table table-hover">
              <thead>
                 <tr>
                     <th>#</th>
                     <th>아이디</th>
                     <th>이름</th>
                     <th>주소</th>
                 </tr>
              </thead>
              <tbody>
                 <tr>
                     <th>1</th>
                     <th>tomato</th>
                     <th>토마토</th>
                     <th>서울 금천구 가산동</th>
                 </tr>
              </tbody>
          </table> 
          <hr />    
          <div class='member-footer'>
              <button class="btn btn-warning" onclick="boardList()">
                 전체조회
              </button>&nbsp; 
              <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#memberForm">
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
    <!-- ========================== [[ 회원가입 Modal ]] ========================== -->
    <div class="modal" id="memberForm">
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
    
          <!-- Modal Header -->
          <div class="modal-header">
            <h4 class="modal-title">회원가입</h4>
            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
          </div>
    
          <!-- Modal body -->
          <div class="modal-body">
           <form id="f_member">
              <div class="form-floating mb-3 mt-3">
                <input type="text"  class="form-control" id="mem_id" name="mem_id" placeholder="Enter 아이디" />
                <label for="mem_id">아이디</label>
              </div>          
              <div class="form-floating mb-3 mt-3">
                <input type="text"  class="form-control" id="mem_pw" name="mem_pw" placeholder="Enter 비밀번호" />
                <label for="mem_pw">비밀번호</label>
              </div>          
              <div class="form-floating mb-3 mt-3">
                <input type="text"  class="form-control" id="mem_name" name="mem_name" placeholder="Enter 이름" />
                <label for="mem_name">이름</label>
              </div>          
           </form>
          </div>
    
          <!-- Modal footer -->
          <div class="modal-footer">
            <button type="button" class="btn btn-warning" data-bs-dismiss="modal">Add</button>
            <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
          </div>
    
        </div>
      </div>
    </div>
    <!-- ========================== [[ 회원가입 Modal ]] ========================== -->    
</body>
</html>