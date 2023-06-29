<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String s_name = (String)session.getAttribute("s_name");
%>    
    	<span class="loginMsg">
          	<font color="black"><%=s_name %>님 환영합니다.</font>
        </span>
        &nbsp;&nbsp;
        <button type="button" class="btn btn-outline-success" onclick="logoutAction()">LogOut</button>
        <button type="button" id="btnUpdate" class="btn btn-primary" onclick="memberUpdateForm()">정보수정</button>

        