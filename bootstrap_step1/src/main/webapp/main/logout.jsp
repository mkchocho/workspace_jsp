<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate();
%>    
          <form class="d-flex">
            <input
              class="form-control me-2"
              type="text"
              id="mem_id"
              placeholder="아이디"
              aria-label="Search"
            />
            <input
              class="form-control me-2"
              type="text"
              id="mem_pw"
              placeholder="비밀번호"
              aria-label="Search"
            />
            <button id="login" class="btn btn-outline-success" type="button" onclick="loginAction()">Login</button>         
          </form>