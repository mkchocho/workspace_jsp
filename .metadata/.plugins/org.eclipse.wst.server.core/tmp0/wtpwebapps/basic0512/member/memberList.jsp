<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map, java.util.ArrayList" %>        
<%
    // 스크립틀릿 - 지변, 메소드선언 불가함, 인스턴스화 가능함
    int size = 0;// 지변이니까 초기화를 생략하면 에러발생함
    List<Map<String,Object>> mList = (List<Map<String,Object>>)request.getAttribute("mList");
    if(mList !=null) {
      size = mList.size();// 3	
    }
    //out.print(size);// 0이 출력됨
    //out.print(mList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<%@include file="/common/bootstrap_common.jsp"%>
<link rel="stylesheet" href="/css/member.css">
<script type="text/javascript">
//검색 버튼을 눌렀을 때 호출되는 함수 입니다.
    const memberSearch = () => {
    	const gubun = document.querySelector("#gubun").value;//분류선택-mem_id, mem_name, mem_address
    	const keyword = document.querySelector("#keyword").value;//사용자가 입력한 키워드
        //console.log(gubun + ", " + keyword);
    	//브라우저 내장객체 중 최상위 객체 -window  객체임
		 //window.location은 location도 window객체의 자손을 뜻하는 것임
window.location.href="http://localhost:9000/member/memberCRUD?method=memberSelect&gubun="+gubun+"&keyword="+keyword;

    }
    
    const searchEnter = (event) => {
    	if(window.event.keyCode ==13){
    		memberSearch();
    	}
    }
</script>
</head>
<body>
    <!-- header start -->
    <%@include file="/include/gym_header.jsp"%>
    <!-- header end -->
    <!-- body start -->
    <div class="container">
       <div class="page-header">
          <h2>회원관리<small>회원목록</small></h2>
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
                  aria-label="검색어를 입력하세요" aria-describedby="btn_search"  onkeyup="searchEnter()"/>
          </div>
          <div class="col-3">
             <button id="btn_search" class="btn btn-danger" onclick="memberSearch()">검색</button>
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
<%
  for(int i=0; i<size; i++) {
  	Map<String, Object> rmap = mList.get(i);

%>              
                 <tr>
                     <th><%= rmap.get("mem_no") %></th>
                     <th><%= rmap.get("mem_id") %></th>
                     <th><%= rmap.get("mem_name") %></th>
                     <th><%= rmap.get("mem_address") %></th>
                 </tr>
<%
	}// end of for
%>                                  
              </tbody>
          </table> 
          <hr />    
          <div class='member-footer'>
              <button class="btn btn-warning" onclick="memberSearch()">
              전체조회
              </button>&nbsp; 
              <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#memberForm">
              회원가입
              </button>
           </div>
       </div>    
       <!-- 회원목록 끝 -->    
       
    </div>
    <!-- body end -->
    <!-- footer start -->
    <%@include file="/include/gym_footer.jsp"%>
    <!-- footer end --> 
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