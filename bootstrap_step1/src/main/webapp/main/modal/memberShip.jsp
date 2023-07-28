<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- =============================  [[ 회원가입 section ]]  ============================= -->    
	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">멤버십</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">	      
			<form class="row g-3" id="f_member">
			  <div class="col-md-6">
			    <label for="아이디" class="form-label">아이디</label>
			    <input type="text" class="form-control" id="mem_id" name="mem_id" value='cat123'>
			  </div>
			  <div class="col-md-6">
			    <label for="비밀번호" class="form-label">비밀번호</label>
			    <input type="password" class="form-control" id="mem_pw" name="mem_pw" value='1234'>
			  </div>
			  <div class="col-md-12">
			    <label for="이름" class="form-label">이름</label>
			    <input type="text" class="form-control" id="mem_name" name="mem_name" value='김고양'>
			  </div>
			  <div class="col-md-12">
			  <label for="mem_phone"  class="form-label">휴대폰 번호</label>
				<input type="text" class="form-control" id="mem_phone" name="mem_phone" placeholder="010-1234-5678">
			  </div>
			  <div class="col-md-12">
			  <label for="mem_birth"  class="form-label">생년월일</label>
				<input type="text" class="form-control" id="mem_birth" name="mem_birth" placeholder="1991-01-23">
			  </div>
			  <div class="col-md-3">
			    <label for="우편번호" class="form-label">우편번호</label>
			    <input type="text" class="form-control" id="mem_zipcode" name="mem_zipcode" value='12185'>
			  </div>
			  <div class="col-md-5">
			    <label for="동이름" class="form-label">동이름</label>
			    <input type="text" class="form-control" id="dong" name="dong" value='공덕동' onchange="zipcodeSearch()">
			  </div>
			  <div class="col-md-4">
			    <label for="검색" class="form-label">검색</label>
			    <input type="button" class="btn btn-primary" id="btn_zipcode" value='우편번호찾기' onclick="zipcodeSearch()">
			  </div>
			  
			  <div class="col-12">
			    <label for="inputAddress" class="form-label">주소</label>
			    <input type="text" class="form-control" id="mem_addr"  name="mem_addr" 
			           placeholder="주소" value='서울시 마포구 공덕동'>
			  </div>
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary" onclick="memberShip()">Sign in</button>
	      </div>
	    </div>
	  </div>
	</div>   
    <!-- =============================  [[ 회원가입 section ]]  ============================= -->  