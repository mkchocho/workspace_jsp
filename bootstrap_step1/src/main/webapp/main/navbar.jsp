<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- ============================== [[ NavBar section]] ==============================-->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">구디아카데미</a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="./index.jsp">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="./index.jsp?menu=menu1">공지사항</a>
            </li>
	        <li class="nav-item">
	          <a class="nav-link" href="./index.jsp?menu=menu2">회원관리</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="./index.jsp?menu=menu3">수강신청</a>
	        </li>
          </ul>
<!--[[ LOGIN AREA ]]-->          
          <div id="loginForm">
          <!-- <form class="d-flex"> -->
          <form class="d-flex">
            <input
              class="form-control me-1"
              type="text"
              id="mem_id"
              size="10"
              placeholder="아이디"
              aria-label="Search"
            />
            <input
              class="form-control me-1"
              type="text"
              id="mem_pw"
              size="10"
              placeholder="비밀번호"
              aria-label="Search"
            />
            <button id="login" class="btn btn-outline-success" type="button" onclick="loginAction()">Login</button>         
            &nbsp;
            <button id="membership" class="btn btn-success" type="button" data-bs-toggle="modal" data-bs-target="#exampleModal" >signup</button>         
          </form>
          </div>
<!--[[ LOGIN AREA ]]-->                    
        </div>
      </div>
    </nav>
    <!-- ============================== [[ NavBar section]] ============================== -->