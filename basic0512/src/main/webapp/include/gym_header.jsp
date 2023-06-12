<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="/gym.jsp">TerrGYM</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/auth2/loginForm.jsp">로그인</a>
        </li>
                <li class="nav-item">
          <a class="nav-link" href="/member/memberCRUD?method=memberSelect">회원관리</a>
        </li>
		<li class="nav-item">
          <a class="nav-link" href="/notice/noticeList.pj1">공지사항</a>
        </li>
        
        <li class="nav-item">
          <a class="nav-link" href="/board/boardList.pj2">자유게시판</a>
        </li>
           <li class="nav-item">
          <a class="nav-link" href="#">QnA게시판</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">요가</a>
        </li>
  		<li class="nav-item">
          <a class="nav-link" href="#">PT</a>
        </li>
      </ul>
    </div>
  </div>
</nav>